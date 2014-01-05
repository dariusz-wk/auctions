package pl.edu.agh.eaiib.auctions.webservices;

import java.util.Calendar;
import java.util.List;

import javax.xml.ws.Holder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.utils.Utils;
import pl.edu.agh.eaiib.auctions.webservice.GetAuctionsForClientSoapImpl;
import pl.edu.agh.eaiib.auctions.xsd.AuctionListFilterType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionListType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml", "/task-test-config.xml", "/ws-test.xml" })

public class GetAuctionsForClientSoapTest extends AuctionUnitTestBase {
    @Test
    public void testSearch() {

        List<Auction> ll = auctionService.find(null, false, null, null, null, Calendar.getInstance().getTime(), null);
    	int nbOfAuctions = ll.size();
    	log.debug(ll);
    	
    	prepareAuction();
    	prepareAuctionFinished();
    	prepareAuctionWithBet180();
    	
    	
    	Holder<AuctionListType> auctionList = holder(null);
    	Holder<String> errors = holder(null);
    	AuctionListFilterType auctionListFilter = new AuctionListFilterType();
    	
    	((GetAuctionsForClientSoapImpl)getAuctionsForClientSoap).setContext(getContext());
    	getAuctionsForClientSoap.getAuctionsForClient(holder(CLIENT1), auctionListFilter, auctionList, errors);
    	
    	Assert.assertTrue(Utils.isBlank(errors.value));
    	Assert.assertEquals(nbOfAuctions+2,auctionList.value.getAuction().size());
    	
    };
    
    @Test
    public void testGetSpecific() {
    	
    	prepareAuction();
    	Long id = prepareAuctionFinished();
    	prepareAuctionWithBet180();
    	
    	
    	Holder<AuctionListType> auctionList = holder(null);
    	Holder<String> errors = holder(null);
    	AuctionListFilterType auctionListFilter = new AuctionListFilterType();
    	auctionListFilter.setAuctionId(id.toString());
    	
    	((GetAuctionsForClientSoapImpl)getAuctionsForClientSoap).setContext(getContext());
    	getAuctionsForClientSoap.getAuctionsForClient(holder(CLIENT1), auctionListFilter, auctionList, errors);
    	
    	Assert.assertTrue(Utils.isBlank(errors.value));
    	Assert.assertEquals(1,auctionList.value.getAuction().size());
    	
    };

    @Test
    public void testGetMy() {
    	List<Auction> ll = auctionService.find(null, false, null, null, CLIENT1, null, null);
    	int nbOfAuctions = ll.size();
    	log.debug(ll);
    	
    	prepareAuctionFinished();
    	prepareAuctionWithBet180();
    	prepareAuctionWithBet180();
    	
    	
    	Holder<AuctionListType> auctionList = holder(null);
    	Holder<String> errors = holder(null);
    	AuctionListFilterType auctionListFilter = new AuctionListFilterType();
    	auctionListFilter.setMy(true);
    	
    	((GetAuctionsForClientSoapImpl)getAuctionsForClientSoap).setContext(getContext());
    	getAuctionsForClientSoap.getAuctionsForClient(holder(CLIENT1), auctionListFilter, auctionList, errors);
    	
    	Assert.assertTrue(Utils.isBlank(errors.value));
    	Assert.assertEquals(nbOfAuctions+2,auctionList.value.getAuction().size());
    	

    	auctionListFilter.setFinished(true);
    	((GetAuctionsForClientSoapImpl)getAuctionsForClientSoap).setContext(getContext());
    	getAuctionsForClientSoap.getAuctionsForClient(holder(CLIENT2), auctionListFilter, auctionList, errors);
    	
    	Assert.assertTrue(Utils.isBlank(errors.value));
    	Assert.assertEquals(nbOfAuctions+1,auctionList.value.getAuction().size());
    	Assert.assertTrue(Utils.isNotBlank(auctionList.value.getAuction().get(nbOfAuctions).getAuctionManagerContactData().getAMName()));
    	Assert.assertTrue(Utils.isNotBlank(auctionList.value.getAuction().get(nbOfAuctions).getClientContactData().getClientEmail()));
    };
}
