package pl.edu.agh.eaiib.auctions.webservices;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.agh.eaiib.auctions.dao.AuctionDao;
import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.model.Bet;
import pl.edu.agh.eaiib.auctions.service.AuctionService;
import pl.edu.agh.eaiib.auctions.service.AuthServiceImpl;
import pl.edu.agh.eaiib.auctions.utils.Utils;
import pl.edu.agh.eaiib.auctions.webservice.PutAuctionByManagerSoapImpl;
import pl.edu.agh.eaiib.auctions.webservice.PutAuctionFinalizationFormByClientSoapImpl;
import pl.edu.agh.eaiib.auctions.webservice.PutBetByClientSoapImpl;
import pl.edu.agh.eaiib.auctions.wsdl.GetAuctionsForClientSoap;
import pl.edu.agh.eaiib.auctions.wsdl.GetAuctionsForManagerSoap;
import pl.edu.agh.eaiib.auctions.wsdl.PutAuctionByManagerSoap;
import pl.edu.agh.eaiib.auctions.wsdl.PutAuctionFinalizationFormByClientSoap;
import pl.edu.agh.eaiib.auctions.wsdl.PutBetByClientSoap;
import pl.edu.agh.eaiib.auctions.xsd.AuctionManagerContactDataType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionType;
import pl.edu.agh.eaiib.auctions.xsd.BetType;
import pl.edu.agh.eaiib.auctions.xsd.ClientContactDataType;

public abstract class AuctionUnitTestBase {

    static final String CLIENT2 = "CLIENTT";

    static final String CLIENT1 = "CLIENT";

    static final String AMTEST = "AMTEST";

    final Logger log = Logger.getLogger(getClass());

    @Autowired
    PutAuctionByManagerSoap putAuctionByManagerSoap;

    @Autowired
    PutBetByClientSoap putBetByClientSoap;

    @Autowired
    PutAuctionFinalizationFormByClientSoap putAuctionFinalizationFormByClientSoap;

    @Autowired
    AuctionService auctionService;

    @Autowired
    AuctionDao auctionDao;

    @Autowired
    GetAuctionsForManagerSoap getAuctionsForManagerSoap;

    @Autowired
    GetAuctionsForClientSoap getAuctionsForClientSoap;

    public AuctionUnitTestBase() {
        super();
    }

    protected WebServiceContext getContext() {
        WebServiceContext context = Mockito.mock(WebServiceContext.class);
        MessageContext msgContext = Mockito.mock(MessageContext.class);
        Map<Object, Object> http_headers = new HashMap<Object, Object>();
        http_headers.put(AuthServiceImpl.USERNAME_PROPERTY, Arrays.asList(new String[] { AMTEST }));
        http_headers.put(AuthServiceImpl.PASSWORD_PROPERTY, Arrays.asList(new String[] { "1234567" }));
        Mockito.when(msgContext.get(MessageContext.HTTP_REQUEST_HEADERS)).thenReturn(http_headers);
        Mockito.when(context.getMessageContext()).thenReturn(msgContext);
        return context;
    }

    protected AuctionManagerContactDataType getAMData() {
        AuctionManagerContactDataType auctionManagerContactData = new AuctionManagerContactDataType();
        auctionManagerContactData.setAMAccountBank("ING");
        auctionManagerContactData.setAMAccountNb("61 1090 1014 0000 0712 1981 2874");
        auctionManagerContactData.setAMEmail("a@mail.com");
        auctionManagerContactData.setAMName("PITER");
        auctionManagerContactData.setAMPhone("876765213");
        auctionManagerContactData.setAMSurname("PARKER");
        return auctionManagerContactData;
    }

    protected AuctionType getAuctionType() {
        AuctionType auction = new AuctionType();
        auction.setAMLogin(AMTEST);
        auction.setAuctionDeliveryDesc("DELIVERY DESC");
        auction.setAuctionEnd(date("2015-02-02T15:00:00Z"));
        auction.setAuctionStart(date("2013-12-02T15:00:00Z"));
        auction.setAuctionStartPrice("120.50");
        auction.setAuctionTitle("NEW SHOOES");
        auction.setAuctionDescription("DESC");
        return auction;
    }

    Long prepareAuction() {
        AuctionType auction = getAuctionType();

        String amLogin = AMTEST;

        AuctionManagerContactDataType auctionManagerContactData = getAMData();

        String errors = "";

        WebServiceContext context = getContext();

        ((PutAuctionByManagerSoapImpl) putAuctionByManagerSoap).setContext(context);
        Holder<String> e = holder(errors);
        Holder<AuctionType> a = holder(auction);
        putAuctionByManagerSoap.putAuctionByManager(a, holder(amLogin), auctionManagerContactData, e);
        log.debug(a.value);
        return Utils.parseLong(a.value.getAuctionId());
    }

    public <T> Holder<T> holder(T type) {
        Holder<T> h = new Holder<T>(type);
        return h;
    }

    public XMLGregorianCalendar date(String dateString) {
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(dateString);
        } catch (DatatypeConfigurationException e) {
            return null;
        }
    }

    Long prepareAuctionWithBet180() {
        Long id = prepareAuction();
        Assert.assertNotNull(id);

        BetType bet = new BetType();
        bet.setBetPrice("150.00");
        Holder<String> errors = holder("");
        Holder<AuctionType> auction = holder((AuctionType) null);
        ((PutBetByClientSoapImpl) putBetByClientSoap).setContext(getContext());
        putBetByClientSoap.putBetByClient(holder(CLIENT1), id.toString(), bet, auction, errors);

        log.debug(errors.value);
        Assert.assertTrue(Utils.isBlank(errors.value));

        bet = new BetType();
        bet.setBetPrice("180.00");
        errors = holder("");
        auction = holder((AuctionType) null);
        ((PutBetByClientSoapImpl) putBetByClientSoap).setContext(getContext());
        putBetByClientSoap.putBetByClient(holder(CLIENT2), id.toString(), bet, auction, errors);

        log.debug(errors.value);
        Assert.assertTrue(Utils.isBlank(errors.value));

        Auction ac = auctionService.get(id);
        List<Bet> b = ac.getBetList();
        Assert.assertEquals(2, b.size());

        Assert.assertEquals(b.get(b.size() - 1).getBetPrice(), 180.0, 0.1);
        return id;
    }

    Long prepareAuctionFinished() {
        Long id = prepareAuctionWithBet180();
        Assert.assertNotNull(id);

        Auction ac = auctionService.get(id);
        Assert.assertNotNull(ac);

        ac.setFinished(true);
        auctionService.update(ac);

        ClientContactDataType clientContactData = new ClientContactDataType();
        clientContactData.setClientAddress("DOM ");
        clientContactData.setClientEmail("an@e.mail");
        clientContactData.setClientName("JOHN");
        clientContactData.setClientPhone("999999999");
        clientContactData.setClientSurname("DOE");

        // CLIENT thinks he won
        Holder<String> errors = holder("");
        Holder<AuctionManagerContactDataType> adata = holder((AuctionManagerContactDataType) null);

        ((PutAuctionFinalizationFormByClientSoapImpl) putAuctionFinalizationFormByClientSoap).setContext(getContext());
        putAuctionFinalizationFormByClientSoap.putAuctionFinalizationFormByClient(id.toString(), holder(CLIENT2), clientContactData, holder(AMTEST), adata,
                holder(new AuctionType()), errors);
        log.debug(errors.value);
        Assert.assertTrue(Utils.isBlank(errors.value));
        Assert.assertNotNull(adata.value);
        return id;
    }

}