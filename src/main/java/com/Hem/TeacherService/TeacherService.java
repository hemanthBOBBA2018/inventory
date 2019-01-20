package com.hemanth.Service;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hemanth.Dao.TeacherDao;
import com.hemanth.Dao.TeacherDaoImpl;
import com.hemanth.Controller.TeacherNotFoundException;
import com.hemanth.Model.Teacher;


//Every service shoud be interface
// Why is the service? what it will handle 

//Service to busines logic - service is what we offer



@Service
public class TeacherService {
	
	@Autowired
	@Qualifier("mongo")
	private TeacherDao<Teacher> DaoImpl;
	
	//Remove the initTeacherService
	//Post construct annotatoin
	
	/*
	 * @PostConstruct public void InitTeacherService(){
	 * 
	 * System.out.println("I am here in Service Layer"); Teacher t1 = new Teacher();
	 * 
	 * t1.setId(new ObjectId(new Date())); t1.setFullname("123"); t1.setGender('M');
	 * t1.setMobileNumber("9739014678"); t1.setQualification("B.E");
	 * t1.setAddress("Banashankari");
	 * 
	 * DaoImpl.saveTeacherData(t1);
	 * 
	 * 
	 * Teacher t2 = new Teacher(); t2.setId(new ObjectId(new Date()));
	 * t2.setFullname("Viswanath"); t2.setGender('M');
	 * t2.setMobileNumber("9739014678"); t2.setQualification("B.E");
	 * t2.setAddress("Banashankari");
	 * 
	 * DaoImpl.saveTeacherData(t2);
	 * 
	 * 
	 * }
	 */
	
	     public boolean CheckTeacherId(String id)
	     {
		/*
		 * if (!DaoImpl.teacherRepo.containsKey(id)) return false; else return true;
		 */
	    	 
	    	 return false;
	    	
	     }

		public Teacher getTecherDetailsGivenFullName(String name) {
			return DaoImpl.findTeacher(name);
		}
	     }
	

