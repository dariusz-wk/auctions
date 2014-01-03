package pl.edu.agh.eaiib.auctions.webservices;

import javax.xml.ws.Holder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.edu.agh.eaiib.auctions.utils.Utils;
import pl.edu.agh.eaiib.auctions.webservice.GetAuctionsForManagerSoapImpl;
import pl.edu.agh.eaiib.auctions.xsd.AuctionListFilterType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionListType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml", "/task-test-config.xml", "/ws-test.xml" })
public class GetAuctionsForManagerSoapTest extends AuctionUnitTestBase {

    @Test
    public void testRunningAuctions() {
        int auctionsForUser = auctionDao.find(null, false, false, AMTEST, null, null, null).size();

        prepareAuction();
        prepareAuctionWithBet180();
        prepareAuctionFinished();

        AuctionListFilterType auctionListFilter = new AuctionListFilterType();
        auctionListFilter.setMy(true);

        Holder<AuctionListType> auctionList = holder((AuctionListType) null);
        Holder<String> errors = holder("");
        ((GetAuctionsForManagerSoapImpl) getAuctionsForManagerSoap).setContext(getContext());
        getAuctionsForManagerSoap.getAuctionsForManager(holder(AMTEST), auctionListFilter, auctionList, errors);

        log.debug(errors.value);
        Assert.assertTrue(Utils.isBlank(errors.value));
        Assert.assertNotNull(auctionList.value);
        Assert.assertNotNull(auctionList.value.getAuction());
        Assert.assertEquals(auctionsForUser + 2, auctionList.value.getAuction().size());

        for (AuctionType a : auctionList.value.getAuction()) {
            Assert.assertNull(a.getAuctionManagerContactData());

            Assert.assertNull(a.getClientContactData());
        }
        log.debug(auctionList.value.getAuction());

    };

    @Test
    public void testFinishedAuctions() {
        int auctionsForUser = auctionDao.find(null, true, false, AMTEST, null, null, null).size();

        prepareAuction();
        prepareAuctionWithBet180();
        prepareAuctionFinished();

        AuctionListFilterType auctionListFilter = new AuctionListFilterType();
        auctionListFilter.setMy(true);
        auctionListFilter.setFinished(true);

        Holder<AuctionListType> auctionList = holder((AuctionListType) null);
        Holder<String> errors = holder("");
        ((GetAuctionsForManagerSoapImpl) getAuctionsForManagerSoap).setContext(getContext());
        getAuctionsForManagerSoap.getAuctionsForManager(holder(AMTEST), auctionListFilter, auctionList, errors);

        log.debug(errors.value);
        Assert.assertTrue(Utils.isBlank(errors.value));
        Assert.assertNotNull(auctionList.value);
        Assert.assertNotNull(auctionList.value.getAuction());
        Assert.assertEquals(auctionsForUser + 1, auctionList.value.getAuction().size());

        for (AuctionType a : auctionList.value.getAuction()) {
            Assert.assertNotNull(a.getAuctionManagerContactData());
            log.debug(a.getAuctionManagerContactData());

            if ( a.isFinalized() ) {
                Assert.assertNotNull(a.getClientContactData());
                log.debug(a.getClientContactData());
            }
        }
        log.debug(auctionList.value.getAuction());

    };

    @Test
    public void testSpecificAuctions() {
        int auctionsForUser = auctionDao.find(null, true, false, AMTEST, null, null, null).size();

        Long id1 = prepareAuction();
        Long id2 = prepareAuctionWithBet180();
        Long id3 = prepareAuctionFinished();

        AuctionListFilterType auctionListFilter = new AuctionListFilterType();
        auctionListFilter.setAuctionId(id1.toString());

        Holder<AuctionListType> auctionList = holder((AuctionListType) null);
        Holder<String> errors = holder("");
        ((GetAuctionsForManagerSoapImpl) getAuctionsForManagerSoap).setContext(getContext());
        getAuctionsForManagerSoap.getAuctionsForManager(holder(AMTEST), auctionListFilter, auctionList, errors);

        log.debug(errors.value);
        Assert.assertTrue(Utils.isBlank(errors.value));
        Assert.assertNotNull(auctionList.value);
        Assert.assertNotNull(auctionList.value.getAuction());
        Assert.assertEquals(1, auctionList.value.getAuction().size());

        for (AuctionType a : auctionList.value.getAuction()) {
            Assert.assertNull(a.getAuctionManagerContactData());
            Assert.assertEquals(0, a.getBetList().getBet().size());
            Assert.assertNull(a.getClientContactData());

        }
        log.debug(auctionList.value.getAuction());
        //
        auctionListFilter = new AuctionListFilterType();
        auctionListFilter.setAuctionId(id2.toString());

        auctionList = holder((AuctionListType) null);
        errors = holder("");
        ((GetAuctionsForManagerSoapImpl) getAuctionsForManagerSoap).setContext(getContext());
        getAuctionsForManagerSoap.getAuctionsForManager(holder(AMTEST), auctionListFilter, auctionList, errors);

        log.debug(errors.value);
        Assert.assertTrue(Utils.isBlank(errors.value));
        Assert.assertNotNull(auctionList.value);
        Assert.assertNotNull(auctionList.value.getAuction());
        Assert.assertEquals(1, auctionList.value.getAuction().size());

        for (AuctionType a : auctionList.value.getAuction()) {
            Assert.assertNull(a.getAuctionManagerContactData());
            Assert.assertNull(a.getClientContactData());
            Assert.assertEquals(2, a.getBetList().getBet().size());

        }
        log.debug(auctionList.value.getAuction());
        //
        auctionListFilter = new AuctionListFilterType();
        auctionListFilter.setAuctionId(id3.toString());

        auctionList = holder((AuctionListType) null);
        errors = holder("");
        ((GetAuctionsForManagerSoapImpl) getAuctionsForManagerSoap).setContext(getContext());
        getAuctionsForManagerSoap.getAuctionsForManager(holder(AMTEST), auctionListFilter, auctionList, errors);

        log.debug(errors.value);
        Assert.assertTrue(Utils.isBlank(errors.value));
        Assert.assertNotNull(auctionList.value);
        Assert.assertNotNull(auctionList.value.getAuction());
        Assert.assertEquals(1, auctionList.value.getAuction().size());

        for (AuctionType a : auctionList.value.getAuction()) {
            Assert.assertNotNull(a.getAuctionManagerContactData());
            Assert.assertNotNull(a.getClientContactData());
            Assert.assertEquals(2, a.getBetList().getBet().size());

        }
        log.debug(auctionList.value.getAuction());

    };
}
