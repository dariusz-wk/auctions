package pl.edu.agh.eaiib.auctions.webservices;

import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.utils.Utils;
import pl.edu.agh.eaiib.auctions.webservice.PutAuctionByManagerSoapImpl;
import pl.edu.agh.eaiib.auctions.xsd.AuctionManagerContactDataType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml", "/task-test-config.xml", "/ws-test.xml" })
public class PutAuctionByManagerSoapTest extends AuctionUnitTestBase {

    @Test
    public void testValidInsert() {
        int startupSize = auctionDao.getAllIds().size();

        AuctionType auction = getAuctionType();

        String amLogin = "AMTEST";

        AuctionManagerContactDataType auctionManagerContactData = getAMData();

        String errors = "";

        WebServiceContext context = getContext();

        ((PutAuctionByManagerSoapImpl) putAuctionByManagerSoap).setContext(context);
        Holder<String> e = holder(errors);
        Holder<AuctionType> a = holder(auction);
        putAuctionByManagerSoap.putAuctionByManager(a, holder(amLogin), auctionManagerContactData, e);

        log.debug(e.value);
        Assert.assertTrue(Utils.isBlank(e.value));

        int afterAddSize = auctionDao.getAllIds().size();

        Assert.assertEquals(startupSize + 1, afterAddSize);

        Assert.assertTrue(Utils.isNotBlank(a.value.getAuctionId()));

        Auction ac = auctionService.get(Utils.parseLong(a.value.getAuctionId()));

        Assert.assertNotNull(ac);
        Assert.assertNotNull(ac.getAuctionManagerContact());

        log.debug(ac);
    }
}
