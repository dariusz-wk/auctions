package pl.edu.agh.eaiib.auctions.service;

import java.util.Date;
import java.util.List;

import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.model.Bet;

public interface AuctionService {

	Long save(Auction auctionBean);
	void update(Auction auctionBean);

	Auction addBet(Long auctionId, Bet betBean);

	Auction get(Long auctionId);
	
	List<Auction> find(String title, boolean finished,boolean finalized, String amLogin, String clientLogin, Date from, Date till);
	
	List<Auction> findToFinish();
}
