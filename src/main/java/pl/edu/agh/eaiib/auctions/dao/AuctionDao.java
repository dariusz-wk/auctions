package pl.edu.agh.eaiib.auctions.dao;

import java.util.Date;
import java.util.List;

import pl.edu.agh.eaiib.auctions.core.dao.BaseDao;
import pl.edu.agh.eaiib.auctions.model.Auction;

public interface AuctionDao extends BaseDao<Auction, Long> {
	List<Auction> find(String title, boolean finished, boolean finalized, String amLogin, String clientLogin, Date from, Date till);
}
