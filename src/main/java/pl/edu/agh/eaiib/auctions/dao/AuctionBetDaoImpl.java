package pl.edu.agh.eaiib.auctions.dao;

import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.eaiib.auctions.core.dao.BaseDaoImpl;
import pl.edu.agh.eaiib.auctions.model.AuctionBetBean;
@Transactional
public class AuctionBetDaoImpl extends BaseDaoImpl<AuctionBetBean, Long> implements AuctionBetDao {

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public AuctionBetBean getEager(Long id) {
		AuctionBetBean bet =get(id);
		Hibernate.initialize(bet.getAuction());
		return bet;
	}

}
