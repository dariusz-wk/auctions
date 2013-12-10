package pl.edu.agh.eaiib.auctions.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.edu.agh.eaiib.auctions.model.AMContact;
import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.model.Bet;
import pl.edu.agh.eaiib.auctions.model.BuyerContact;
import pl.edu.agh.eaiib.auctions.model.Image;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml" })
public class AuctionModelTest {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	DBCleanerBean dbCleanerBean;

	@Test
	public void basicTest() {
		Session session = sessionFactory.openSession();

		Auction auction = new Auction();
		auction.setAmLogin("ADMIN");
		auction.setAuctionCurrentPrice(100.0);
		auction.setAuctionDeliveryDesc("Bla bla bla");
		auction.setAuctionDescription("Bla");
		auction.setAuctionEnd(new Date());
		auction.setAuctionStart(new Date());
		auction.setAuctionStartPrice(90.0);
		auction.setAuctionTitle("AUCTION TEST");

		Long id = (Long) session.save(auction);
		Assert.assertNotNull(id);
		Long auctionId = id;

		Auction savedAuction = (Auction) session.get(Auction.class, id);
		Assert.assertNotNull(savedAuction);

		Image i1 = new Image();
		i1.setAuction(auction);
		i1.setUrl("url1");
		savedAuction.addAuctionImgUrl(i1);

		id = (Long) session.save(i1);
		Assert.assertNotNull(id);

		Image i2 = new Image();
		i2.setAuction(auction);
		i2.setUrl("url2");
		savedAuction.addAuctionImgUrl(i2);

		id = (Long) session.save(i2);
		Assert.assertNotNull(id);

		AMContact amc = new AMContact();
		amc.setBank("ING");
		amc.setBankAccountNb("1234123212343233");
		amc.setEmail("A@S.A");
		savedAuction.setAuctionManagerContact(amc);

		session.update(savedAuction);
		
		BuyerContact b = new BuyerContact();
		b.setAuction(auction);
		b.setEmail("BUYER@S.A");
		savedAuction.setBuyerContact(b);


		session.update(savedAuction);

		Bet bet = new Bet();
		bet.setBetPrice(90.0);
		bet.setBetTime(new Date());
		bet.setCientId("CLIENT");
		savedAuction.addBet(bet);
		
		session.update(savedAuction);
		
		bet = new Bet();
		bet.setBetPrice(100.0);
		bet.setBetTime(new Date());
		bet.setCientId("CLIENT");
		savedAuction.addBet(bet);
		
		id = (Long) session.save(bet);
		Assert.assertNotNull(id);

		session.update(savedAuction);

		savedAuction = (Auction) session.get(Auction.class, auctionId);
		
		session.close();

		Assert.assertEquals(100.0, savedAuction.getAuctionCurrentPrice(), 0.001);
		Assert.assertEquals(2, savedAuction.getAuctionImgUrl().size());
		Assert.assertNotNull(savedAuction.getAuctionManagerContact());
		Assert.assertNotNull(savedAuction.getBuyerContact());
		Assert.assertEquals(2, savedAuction.getBetList().size());
		
	}

	@After
	public void clean() {
		dbCleanerBean.clean();
	}
}
