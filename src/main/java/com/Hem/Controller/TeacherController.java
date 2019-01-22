package com.hemanth.Controller;

import java.awt.PageAttributes.MediaType;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	/*
	@GetMapping(value = "/name={name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Teacher searchTeacherDeatils(@PathVariable("name") String name) {
		return teacherService.getTecherDetailsGivenFullName(name);
	}*/
	
	@RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET)
public  Teacher GetTeacherDetailsById(@PathVariable("id") String id) {
       return teacherService.getSpecificTeacherById(id);
	}
       
     /*  @RequestMapping(value = "/teachers", method = RequestMethod.GET)
       public  Teacher SearchTeacherDetailsByLocation(@RequestParam("address") @NotNull String address) {
              return teacherService.getTeacherDetailsByLocation(address);
       */
	/*
	@GetMapping(value = "/location={location}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Teacher SearchTeacherDetailsByLocation(@PathVariable("address") String location) {
		return teacherService.getTeacherDetailsByLocation(location);
	*/
		
              @PostMapping("/teachers")
            	public void createTeacher(@RequestBody Teacher newTeacher1) {
            		 teacherService.saveTeacher(newTeacher1);
                }  
              
       
	}
	 
	//public String create(@RequestBody Teacher teacher) {
		//service.save(teacher);
	//}
	

