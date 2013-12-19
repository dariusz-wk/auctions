package pl.edu.agh.eaiib.auctions.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.eaiib.auctions.DBCleanerBean;
import pl.edu.agh.eaiib.auctions.model.AMContact;
import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.model.Bet;
import pl.edu.agh.eaiib.auctions.model.BuyerContact;
import pl.edu.agh.eaiib.auctions.model.Image;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml","/test-db-init.xml" })
public class AuctionDaoTest {

	@Autowired
	AuctionDao auctionDao;
	@Autowired
	DBCleanerBean cleanerBean;
	
	@Test
	public void basicTest() {
		Assert.assertNotNull(auctionDao);
		
		Auction auction = new Auction();
		auction.setAmLogin("ADMIN");
		auction.setAuctionCurrentPrice(100.0);
		auction.setAuctionDeliveryDesc("Bla bla bla");
		auction.setAuctionDescription("Bla");
		auction.setAuctionEnd(new Date());
		Image i1 = new Image();
		i1.setAuction(auction);
		i1.setUrl("url1");
		Image i2 = new Image();
		i2.setAuction(auction);
		i2.setUrl("url2");
		auction.setAuctionImgUrl(Arrays.asList(new Image[]{i1,i2}));
		auction.setAuctionStart(new Date());
		auction.setAuctionStartPrice(90.0);
		auction.setAuctionTitle("AUCTION TEST");
		
		AMContact amc = new AMContact();
		amc.setAuction(auction);
		amc.setBank("ING");
		amc.setBankAccountNb("1234123212343233");
		amc.setEmail("A@S.A");
		auction.setAuctionManagerContact(amc);

		BuyerContact b = new BuyerContact();
		b.setAuction(auction);
		b.setEmail("BUYER@S.A");
		auction.setBuyerContact(b);
		
		
		List<Bet> bets = new ArrayList<Bet>();

		Bet bet = new Bet();
		bet.setBetPrice(90.0);
		bet.setBetTime(new Date());
		bet.setCientId("CLIENT");
		bet.setAuction(auction);
		
		bets.add(bet);
		
		bet = new Bet();
		bet.setBetPrice(100.0);
		bet.setBetTime(new Date());
		bet.setCientId("CLIENT");
		bet.setAuction(auction);
		
		bets.add(bet);
		
		auction.setBetList(bets);
		
		auctionDao.save(auction);
		
		List<Long> ids = auctionDao.getAllIds();
		Assert.assertNotNull(ids);
		Assert.assertEquals(1, ids.size());
		
		for(Long id: ids){
			Auction savedAuction = auctionDao.getEager(id);
			Assert.assertEquals(100.0, savedAuction.getAuctionCurrentPrice(), 0.001);
			Assert.assertEquals(2, savedAuction.getAuctionImgUrl().size());
			Assert.assertNotNull(savedAuction.getAuctionManagerContact());
			Assert.assertNotNull(savedAuction.getBuyerContact());
			List<Bet> savedBets = savedAuction.getBetList(); 
			Assert.assertEquals(2, savedBets.size());
			for(Bet savedBet: savedBets){
				Assert.assertEquals(95.0, savedBet.getBetPrice(), 5.001);				
			}
		}
	}
	
	
	@After
	public void clean(){
		cleanerBean.clean();
	}
}
