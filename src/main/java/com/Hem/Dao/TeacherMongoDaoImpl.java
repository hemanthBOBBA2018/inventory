package com.hemanth.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.hemanth.Model.Teacher;
import com.mongodb.DBCollection;

@Component
@Qualifier("mongo")
public class TeacherMongoDaoImpl implements TeacherDao<Teacher> {

	@Autowired
	private MongoTemplate mongotemp;

	@Override
	public void saveTeacherData(Teacher t) {
		System.out.println("Mongo inster	");
		
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(t.getId()));
		System.out.println("The value of Id while Inserting is "+t.getId());
				
		if ( mongotemp.findOne(query, Teacher.class) == null )
			mongotemp.save(t);
		else
			System.out.println(" Teacher Not found");
	}

	@Override
	public Teacher findTeacher(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("fullname").is(name));
		return mongotemp.findOne(query, Teacher.class);
	}
	
	@Override
	public List<Teacher> findAllTeachers() {
		List<Teacher> teachers = mongotemp.findAll(Teacher.class);
		
		for (Teacher temp : teachers) {

	        // I am getting an "null" value instead of the value 
	        System.out.println(temp.getFullname());

	        //This displays something like this : mongodb.model.ILites@732cbcd5 (which i don't really understand)
	        System.out.println(temp);
	    }
		return teachers;
		//return mongotemp.findAll(Teacher.class);
	}
	
	
	@Override
	public Teacher GetTeacher(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		System.out.println("The value of Id is "+id);
		
        Teacher t3 = mongotemp.findOne(query, Teacher.class);
		
		if ( t3 == null )
			System.out.println(" Teacher Not Found");
		
		
		    return t3;
		
		//Teacher t3 = mongotemp.findOne(query, Teacher.class);
		//System.out.println("tEACHER Details" +t3);
		//return t3;
		
	}
	
	@Override
	public Teacher findTeacherByLocation(String address) {
		Query query = new Query();
		query.addCriteria(Criteria.where("address").is(address));
		return mongotemp.findOne(query, Teacher.class);
	}
	
	
	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(teacher.getId()));
		System.out.println(teacher.getId());
		Teacher t3 = mongotemp.findOne(query, Teacher.class);
		
		if ( t3 == null )
			System.out.println(" Teacher not found");
		else {
		//Update the required fields
		t3.setAddress(teacher.getAddress());
		t3.setQualification(teacher.getQualification());
		
		mongotemp.save(t3);
		}
	}
	
	@Override
	public void deleteTeacher(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		
		if ( mongotemp.findOne(query, Teacher.class) == null )
			System.out.println("Teacher not found");
		else {
			Teacher t3 = mongotemp.findAndRemove(query, Teacher.class);	
		System.out.println("Deleted document : " +t3);
		}
	}
	

}
