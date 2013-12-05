package pl.edu.agh.eaiib.auctions.dao;

import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.eaiib.auctions.core.dao.BaseDaoImpl;
import pl.edu.agh.eaiib.auctions.model.AuctionBean;
@Transactional
public class AuctionDaoImpl extends BaseDaoImpl<AuctionBean, Long> implements AuctionDao {

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public AuctionBean getEager(Long id) {
		AuctionBean auction = get(id);
		auction.getAuctionImgUrl();
		Hibernate.initialize(auction.getBetList());
		return auction;
	}

}
