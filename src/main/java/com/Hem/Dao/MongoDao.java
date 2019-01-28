package com.hemanth.Dao;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;


@Component
public class MongoDao<T> {

	@Autowired
	private MongoTemplate mongotemp;
	
	final static Logger logger = Logger.getLogger(MongoDao.class);
	
	public void save(T object) {
		mongotemp.save(object);
	}

	public List<T> findAll(Class<T> clazz) {
		List<T> teachers = mongotemp.findAll(clazz);
		return teachers;
	}
	

	public List<T> getAll(List<Criteria> criteria ,Class<T> clazz) {
		Query query = new Query();
		for(Criteria cri  : criteria) {
			query.addCriteria(cri);
		}
		return mongotemp.find(query, clazz);
	}

	public void delete(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));

		mongotemp.remove(query, "teachers");
		
	}

}
