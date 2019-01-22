package com.hemanth.Dao;

import com.hemanth.Model.Teacher;
import java.util.List;


//no need of genric when you have specifiv dao

//Dao is a repository pattren. 
public interface TeacherDao<Teacher> {
	
	void saveTeacherData(Teacher t);

	Teacher findTeacher(String name);
	
	Teacher GetTeacher(String id);
	
	Teacher findTeacherByLocation(String address);

	List<Teacher> findAllTeachers();
	
}

/*
//what is genric? is reusablity of code.
		
	//	Techer save,delete, load (CURD)
		//Student (CURD)
		

public interface Dao<T>{
	public void save(T obbject);
	public T get(int id);
}

public class TeacherDao implements Dao<Teacher>{
	public void save(Teacher teacher) {
		
	}
	
}*/
		
		
		

