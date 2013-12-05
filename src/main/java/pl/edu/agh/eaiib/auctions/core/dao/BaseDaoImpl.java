package pl.edu.agh.eaiib.auctions.core.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.eaiib.auctions.core.model.BaseBean;

public abstract class BaseDaoImpl<B extends BaseBean<S>, S extends Serializable> extends HibernateDaoSupport implements BaseDao<B, S> {

	private final Class<B> clazz;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.clazz = (Class<B>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected String getEntityName() {
		return clazz.getSimpleName();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(B obj) {
		getSession().delete(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public B get(S id) {
		return (B) getHibernateTemplate().get(clazz, id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(B obj) {
		getHibernateTemplate().saveOrUpdate(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<S> getAllIds() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("select id from " + getEntityName());
		@SuppressWarnings("unchecked")
		List<S> list = query.list();
		return list;
	}
}
