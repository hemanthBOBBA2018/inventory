package com.Hem.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.Hem.model.Teacher;

@Service
public class TeacherService {
	public Map<String, Teacher> MyService(){
	
	Map<String, Teacher> teacherRepo = new HashMap<String, Teacher>();
	System.out.println("I am here in Service Layer");
		Teacher t1 = new Teacher();
		 t1.setId("10");
		 t1.setFullname("123");
		 t1.setGender('M');
		 t1.setMobileNumber("9739014678");
		 t1.setQualification("B.E");
		 t1.setAddress("Banashankari");
		 
		 Teacher t2 = new Teacher();
		 t2.setId("111");
		 t2.setFullname("Viswanath");
		 t2.setGender('M');
		 t2.setMobileNumber("9739014678");
		 t2.setQualification("B.E");
		 t2.setAddress("Banashankari");
	
		 teacherRepo.put(t1.getId(), t1);
		 teacherRepo.put(t2.getId(), t2);
		 
		 return teacherRepo;
		 
	}
}

