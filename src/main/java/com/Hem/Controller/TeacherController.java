package com.hemanth.Controller;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hemanth.Model.Teacher;
import com.hemanth.Service.TeacherService;

@RestController
public class TeacherController {
		
	@Autowired
	private TeacherService teacherService;
		
	
	//Search TEacher ? name or qalification or any param
	
	//GET MAPPING
	//GET TEACHER DEATILS
	
	//model input -id , output - all the details , where? in-memory ? Dao (TeacherDao) fun -return details -id? , 
	
	@RequestMapping(value = "/teachers", method = RequestMethod.GET)
	public Teacher searchTeacherDeatils(@RequestParam("fullname") @NotNull String name){
		return teacherService.getTecherDetailsGivenFullName(name);		
	}
	
	
	@RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET)
public  Teacher GetTeacherDetailsById(@PathVariable("id") String id) {
       return teacherService.getSpecificTeacherById(id);
       
	}
	 
	//public String create(@RequestBody Teacher teacher) {
		//service.save(teacher);
	//}
	

}
