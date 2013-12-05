package pl.edu.agh.eaiib.auctions.dao;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.edu.agh.eaiib.auctions.model.AuctionBean;
import pl.edu.agh.eaiib.auctions.model.AuctionBetBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml" })
public class AuctionBetDaoTest {

	@Autowired
	AuctionBetDao auctionBetDao;
	@Autowired
	AuctionDao auctionDao;
	@Autowired
	DBCleanerBean cleanerBean;

	@Test
	public void basicTest() {
		Assert.assertNotNull(auctionBetDao);

		AuctionBean auction = new AuctionBean();
		auction.setAmLogin("ADMIN");
		auction.setAuctionCurrentPrice(100.0);
		auction.setAuctionDeliveryDesc("Bla bla bla");
		auction.setAuctionDescription("Bla");
		auction.setAuctionEnd(new Date());
		auction.setAuctionStart(new Date());
		auction.setAuctionStartPrice(90.0);
		auction.setAuctionTitle("AUCTION TEST");
		auctionDao.save(auction);

		Assert.assertEquals(1, auctionDao.getAllIds().size());
		AuctionBean preSavedAuction = auctionDao.get(auctionDao.getAllIds().get(0));
		Assert.assertEquals(100.0, preSavedAuction.getAuctionCurrentPrice(), 0.001);

		AuctionBetBean bet = new AuctionBetBean();
		bet.setBetPrice(100.0);
		bet.setBetTime(new Date());
		bet.setCientId("CLIENT");
		bet.setAuction(auction);

		auctionBetDao.save(bet);

		List<Long> ids = auctionBetDao.getAllIds();
		Assert.assertNotNull(ids);
		Assert.assertEquals(1, ids.size());

		for (Long id : ids) {
			AuctionBetBean savedBet = auctionBetDao.getEager(id);
			Assert.assertEquals(100.0, savedBet.getBetPrice(), 0.001);

			AuctionBean savedAuction = savedBet.getAuction();
			Assert.assertEquals(100.0, savedAuction.getAuctionCurrentPrice(), 0.001);
		}
	}

	@After
	public void clean() {
		cleanerBean.clean();
	}
}
