package pl.edu.agh.eaiib.auctions.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DBCleanerBean {

	@Autowired
	SessionFactory sessionFactory;

	public void clean() {
		
//		Query query = sessionFactory.getCurrentSession().createQuery("delete from Bet");
//		query.executeUpdate();
		//query = sessionFactory.getCurrentSession().createQuery("delete from Contact");
		//query.executeUpdate();
		Query query = sessionFactory.getCurrentSession().createQuery("delete from Auction");
		query.executeUpdate();
	}
}
