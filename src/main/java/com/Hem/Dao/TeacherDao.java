package com.hemanth.Dao;

import com.hemanth.Model.Teacher;
import com.hemanth.search.SearchCritera;

import java.util.List;


//no need of genric when you have specifiv dao

//Dao is a repository pattren. 
public interface TeacherDao {
	
	void saveTeacherData(Teacher t);
	
	Teacher GetTeacher(String id);

	List<Teacher> findAllTeachers();
	
	void updateTeacher(Teacher teacher);
   
	void deleteTeacher(String id);

   	List<Teacher> getTeachers(SearchCritera searchCriteria);
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
		
		
		

