package com.hemanth.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.hemanth.Model.Teacher;

@Component
public class TeacherDaoImpl implements TeacherDao<Teacher>{
	
public Map<String, Teacher> teacherRepo = new HashMap<String, Teacher>();

	@Override
	public
	void saveTeacherData(Teacher t)
	{
		teacherRepo.put(t.getId().toHexString(), t);
	}

	@Override
	public Teacher findTeacher(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
