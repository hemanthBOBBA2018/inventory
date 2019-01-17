package com.Hem.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hem.model.Teacher;

@RestController
public class TeacherController {
	private static Map<String, Teacher> teacherRepo = new HashMap<>();
	
	static {
		Teacher t1 = new Teacher();
		 t1.setId("10");
		 t1.setFullname("Hemanth");
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
		 }
	
	@RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getTeachers(@PathVariable("id") String id){
		System.out.println("I am here in Controller");
		if (!teacherRepo.containsKey(id))
			throw new TeacherNotFoundException();
		return new ResponseEntity<>(teacherRepo.get(id), HttpStatus.OK);
		
	}

}
