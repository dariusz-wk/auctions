package pl.edu.agh.eaiib.auctions.core.dao;

import java.io.Serializable;
import java.util.List;

import pl.edu.agh.eaiib.auctions.core.model.BaseBean;

public interface BaseDao<B extends BaseBean<S>, S extends Serializable> {

	public  void delete(B obj);

	public  B get(S id);
	
	public  B getEager(S id);

	public  void save(B obj);
	
	public List<S> getAllIds();

}