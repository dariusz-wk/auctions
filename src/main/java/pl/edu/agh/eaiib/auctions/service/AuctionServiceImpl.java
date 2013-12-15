package pl.edu.agh.eaiib.auctions.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.eaiib.auctions.dao.AuctionDao;
import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.model.Bet;

public class AuctionServiceImpl implements AuctionService {

	private static final Logger log = Logger.getLogger(AuctionServiceImpl.class);

	@Autowired
	AuctionDao auctionDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Long save(Auction auctionBean) {
		log.debug("creating new auction " + auctionBean.toString());
		return auctionDao.save(auctionBean);

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Auction addBet(Long auctionId, Bet betBean) {
		Auction auction = auctionDao.getEager(auctionId);
		if (auction == null) {
			return null;
		}
		if (auction.getAuctionCurrentPrice() == null && auction.getAuctionStartPrice() - betBean.getBetPrice() >= 0) {
			log.debug("Not enought - bet is less then start price");
			return null;
		}

		if (auction.getAuctionCurrentPrice() != null && auction.getAuctionCurrentPrice() - betBean.getBetPrice() >= 0) {
			log.debug("Not enought - bet is less then start current");
			return null;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(betBean.getBetTime());
		if (cal.after(auction.getAuctionEnd())) {
			log.debug("Bet is too late");
			return null;
		}

		auction.addBet(betBean);
		auction.setAuctionCurrentPrice(betBean.getBetPrice());
		auctionDao.update(auction);
		return auctionDao.get(auctionId);
	}

	@Override
	public Auction get(Long auctionId) {
		return auctionDao.getEager(auctionId);
	}

	@Override
	public List<Auction> find(String title, boolean finished, String amLogin, String clientLogin, Date from, Date till) {
		return auctionDao.find(title, finished, amLogin, clientLogin, from, till);
	}

}
