package pl.edu.agh.eaiib.auctions.service;

import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.agh.eaiib.auctions.dao.AuctionDao;

public class AuctionServiceImpl implements AuctionService{
	
	@Autowired
	AuctionDao auctionDao;
	
	@Autowired
	AuthService authService;

}
