package pl.edu.agh.eaiib.auctions.dao;

import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.eaiib.auctions.core.dao.BaseDaoImpl;
import pl.edu.agh.eaiib.auctions.model.Auction;
@Transactional
public class AuctionDaoImpl extends BaseDaoImpl<Auction, Long> implements AuctionDao {

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Auction getEager(Long id) {
		Auction auction = get(id);
		Hibernate.initialize(auction.getBetList());
		Hibernate.initialize(auction.getAuctionImgUrl());
		Hibernate.initialize(auction.getAuctionManagerContact());
		Hibernate.initialize(auction.getBuyerContact());
		return auction;
	}

}
