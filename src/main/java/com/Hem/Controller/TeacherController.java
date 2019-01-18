package com.Hem.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Hem.model.Teacher;
import com.Hem.service.TeacherService;

@RestController
public class TeacherController {
	//private Map<String, Teacher> teacherRepo =  null;
	
	@Autowired
	private TeacherService teacherService;
	
	
	@RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getTeachers(@PathVariable("id") String id){
		Map<String, Teacher> teacherRepo =  null;
		teacherRepo= (Map<String, Teacher>) teacherService.MyService();
		if (!teacherRepo.containsKey(id))
			throw new TeacherNotFoundException();
		return new ResponseEntity<>(teacherRepo.get(id), HttpStatus.OK);
		
	}

}
