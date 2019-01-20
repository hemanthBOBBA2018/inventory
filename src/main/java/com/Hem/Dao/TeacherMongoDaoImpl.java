package com.hemanth.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.hemanth.Model.Teacher;

@Component
@Qualifier("mongo")
public class TeacherMongoDaoImpl implements TeacherDao<Teacher> {

	@Autowired
	private MongoTemplate mongotemp;

	@Override
	public void saveTeacherData(Teacher t) {
		System.out.println("Mongo inster	");
		mongotemp.save(t);
	}

	@Override
	public Teacher findTeacher(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("fullname").is(name));
		return mongotemp.findOne(query, Teacher.class);
	}

}
