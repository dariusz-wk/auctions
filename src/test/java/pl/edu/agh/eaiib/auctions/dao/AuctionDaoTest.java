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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.eaiib.auctions.model.AuctionBean;
import pl.edu.agh.eaiib.auctions.model.AuctionBetBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml" })
public class AuctionDaoTest {

	@Autowired
	AuctionDao auctionDao;
	@Autowired
	DBCleanerBean cleanerBean;
	
	@Test
	public void basicTest() {
		Assert.assertNotNull(auctionDao);
		
		AuctionBean auction = new AuctionBean();
		auction.setAmLogin("ADMIN");
		auction.setAuctionCurrentPrice(100.0);
		auction.setAuctionDeliveryDesc("Bla bla bla");
		auction.setAuctionDescription("Bla");
		auction.setAuctionEnd(new Date());
		auction.setAuctionImgUrl(Arrays.asList(new String[]{"img1","img2"}));
		auction.setAuctionStart(new Date());
		auction.setAuctionStartPrice(90.0);
		auction.setAuctionTitle("AUCTION TEST");
		
		List<AuctionBetBean> bets = new ArrayList<AuctionBetBean>();
		
		AuctionBetBean bet = new AuctionBetBean();
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
			AuctionBean savedAuction = auctionDao.getEager(id);
			Assert.assertEquals(100.0, savedAuction.getAuctionCurrentPrice(), 0.001);
			List<AuctionBetBean> savedBets = savedAuction.getBetList(); 
			for(AuctionBetBean savedBet: savedBets){
				Assert.assertEquals(100.0, savedBet.getBetPrice(), 0.001);				
			}
		}
	}
	
	
	@After
	public void clean(){
		List<Long> ids = auctionDao.getAllIds();
		for(Long id:ids){
			AuctionBean a = auctionDao.getEager(id);
			a.setAuctionImgUrl(Collections.EMPTY_LIST);
			a.setBetList(Collections.EMPTY_LIST);
			auctionDao.save(a);
		}
		cleanerBean.clean();
	}
}