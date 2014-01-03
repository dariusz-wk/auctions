package pl.edu.agh.eaiib.auctions.webservices;

import java.util.List;

import javax.xml.ws.Holder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.model.Bet;
import pl.edu.agh.eaiib.auctions.utils.Utils;
import pl.edu.agh.eaiib.auctions.webservice.PutBetByClientSoapImpl;
import pl.edu.agh.eaiib.auctions.xsd.AuctionType;
import pl.edu.agh.eaiib.auctions.xsd.BetType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml", "/task-test-config.xml", "/ws-test.xml" })
public class PutBetByClientSoapTest extends AuctionUnitTestBase {

    @Test
    public void testGoodBet() {
        Long id = prepareAuction();
        Assert.assertNotNull(id);

        BetType bet = new BetType();
        bet.setBetPrice("180.00");
        Holder<String> errors = holder("");
        Holder<AuctionType> auction = holder((AuctionType) null);
        ((PutBetByClientSoapImpl) putBetByClientSoap).setContext(getContext());
        putBetByClientSoap.putBetByClient(holder("CLIENTT"), id.toString(), bet, auction, errors);

        log.debug(errors.value);
        Assert.assertTrue(Utils.isBlank(errors.value));
        Assert.assertNotNull(auction.value);

        Auction ac = auctionService.get(id);
        List<Bet> b = ac.getBetList();
        Assert.assertEquals(1, b.size());

        Assert.assertEquals(b.get(0).getBetPrice(), 180.0, 0.1);

    };

    @Test
    public void testSmallBet() {
        Long id = prepareAuctionWithBet180();

        BetType bet = new BetType();
        bet.setBetPrice("110.00");
        Holder<String> errors = holder("");
        Holder<AuctionType> auction = holder((AuctionType) null);
        ((PutBetByClientSoapImpl) putBetByClientSoap).setContext(getContext());
        putBetByClientSoap.putBetByClient(holder("CLIENTT"), id.toString(), bet, auction, errors);

        log.debug(errors.value);
        Assert.assertTrue(Utils.isNotBlank(errors.value));

        Auction ac = auctionService.get(id);
        List<Bet> b = ac.getBetList();
        Assert.assertEquals(2, b.size());

        Assert.assertEquals(b.get(b.size() - 1).getBetPrice(), 180.0, 0.1);

    };
}
