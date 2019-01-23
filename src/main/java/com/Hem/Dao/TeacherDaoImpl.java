package com.hemanth.Dao;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hemanth.Model.Teacher;

@Component
public class TeacherDaoImpl implements TeacherDao<Teacher>{
	
public Map<String, Teacher> teacherRepo = new HashMap<String, Teacher>();

	@Override
	public
	void saveTeacherData(Teacher t)
	{
		//teacherRepo.put(t.getId().toHexString(), t);
		teacherRepo.put(t.getId(), t);
	}

	@Override
	public Teacher findTeacher(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Teacher GetTeacher(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Teacher findTeacherByLocation(String address) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Teacher> findAllTeachers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteTeacher(String id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
