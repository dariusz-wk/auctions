package pl.edu.agh.eaiib.auctions.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.eaiib.auctions.core.dao.BaseDaoImpl;
import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.utils.Utils;
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

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Auction> find(String title, boolean finished, boolean finalized, String amLogin, String clientLogin, Date from, Date till) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria crit = session.createCriteria(Auction.class);
		
		String titleMatch = "%"+(title!=null?title:"")+"%";
		crit.add(Restrictions.ilike("auctionTitle", titleMatch));
		
		crit.add(Restrictions.eq("finished", finished));
		
		crit.add(Restrictions.eq("finalized", finalized));
		
		//TODO: fix me
		if(from!=null && till != null){
			crit.add(Restrictions.between("auctionEnd", from,till));		
		} else if(from !=null){
			crit.add(Restrictions.ge("auctionEnd", from));	
		} else if(till != null){
			crit.add(Restrictions.ge("auctionEnd", till));	
		}
		
		if(Utils.isNotBlank(amLogin)){
			crit.add(Restrictions.eq("amLogin", amLogin));			
		}

		if(Utils.isNotBlank(clientLogin)){
			//TODO: fill me
			
			
		}
		@SuppressWarnings("unchecked")
		List<Auction> list= crit.list();
		for(Auction auction: list){
			Hibernate.initialize(auction.getBetList());
			Hibernate.initialize(auction.getAuctionImgUrl());
			Hibernate.initialize(auction.getAuctionManagerContact());
			Hibernate.initialize(auction.getBuyerContact());
		}
	
		return list;
	}

	@Override
	public List<Auction> findToFinish() {
		Session session = getSessionFactory().getCurrentSession();
		Criteria crit = session.createCriteria(Auction.class);
		
		crit.add(Restrictions.eq("finished", false));
		
		Date currentDate = Calendar.getInstance().getTime();
		
		crit.add(Restrictions.le("auctionEnd", currentDate));	
			
		@SuppressWarnings("unchecked")
		List<Auction> list= crit.list();
		for(Auction auction: list){
			Hibernate.initialize(auction.getBetList());
			Hibernate.initialize(auction.getAuctionImgUrl());
			Hibernate.initialize(auction.getAuctionManagerContact());
			Hibernate.initialize(auction.getBuyerContact());
		}
	
		return list;
	}

}
