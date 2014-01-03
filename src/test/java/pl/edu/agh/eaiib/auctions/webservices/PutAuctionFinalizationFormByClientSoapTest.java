package pl.edu.agh.eaiib.auctions.webservices;

import javax.xml.ws.Holder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.utils.Utils;
import pl.edu.agh.eaiib.auctions.webservice.PutAuctionFinalizationFormByClientSoapImpl;
import pl.edu.agh.eaiib.auctions.xsd.AuctionManagerContactDataType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionType;
import pl.edu.agh.eaiib.auctions.xsd.ClientContactDataType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml", "/task-test-config.xml", "/ws-test.xml" })
public class PutAuctionFinalizationFormByClientSoapTest extends AuctionUnitTestBase {

    @Test
    public void test() {
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
        putAuctionFinalizationFormByClientSoap.putAuctionFinalizationFormByClient(id.toString(), holder(CLIENT1), clientContactData, holder(AMTEST), adata,
                holder(new AuctionType()), errors);
        log.debug(errors.value);
        Assert.assertTrue(Utils.isNotBlank(errors.value));
        Assert.assertNull(adata.value);

        // CLIENTT thinks he won

        errors = holder("");
        adata = holder((AuctionManagerContactDataType) null);
        ((PutAuctionFinalizationFormByClientSoapImpl) putAuctionFinalizationFormByClientSoap).setContext(getContext());
        putAuctionFinalizationFormByClientSoap.putAuctionFinalizationFormByClient(id.toString(), holder(CLIENT2), clientContactData, holder(AMTEST), adata,
                holder(new AuctionType()), errors);
        log.debug(errors.value);
        Assert.assertTrue(Utils.isBlank(errors.value));
        Assert.assertNotNull(adata.value);

        // AM wants to retrive clienrt data

        // TODO: later

    };
}
