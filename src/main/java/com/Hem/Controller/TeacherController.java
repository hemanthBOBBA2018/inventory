package com.hemanth.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.hemanth.search.SearchCriteraLangException;


@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	// Search TEacher ? name or qalification or any param

	// GET MAPPING
	// GET TEACHER DEATILS

	/*** Retrieve all Teachers ***/
	@RequestMapping(value = "/teachers", produces = "application/json", method = RequestMethod.GET)
	public List<Teacher> getAllTeachers() {
		List<Teacher> teacherList = teacherService.getAllTeachers();
		return teacherList;
	}
		

	// model input -id , output - all the details , where? in-memory ? Dao
	// (TeacherDao) fun -return details -id? ,

	/*@RequestMapping(value = "/teachers", method = RequestMethod.GET)
	public Teacher searchTeacherDeatils(@RequestParam("fullname") @NotNull String name) {
		return teacherService.getTecherDetailsGivenFullName(name);
	}
	*/

	
	@RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET)
	public Teacher GetTeacherDetailsById(@PathVariable("id") String id) {
		return teacherService.getSpecificTeacherById(id);
	}

	

	/*** Create a new Teacher ***/
	@PostMapping("/teachers")
	public void createTeacher(@RequestBody Teacher newTeacher1) {
		teacherService.saveTeacher(newTeacher1);
	}

	/** Update the Teacher Details */
	@RequestMapping(value = "/teachers", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateTeacher(@RequestBody Teacher teacher) {
		teacherService.updateTeacher(teacher);
	}

	/** Delete the Teacher Details */
	@RequestMapping(value = "teachers/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteTeacher(@PathVariable("id") String id) {
		teacherService.deleteTeacher(id);
	}
	
	@RequestMapping(value = "teachers/search", method = RequestMethod.GET, produces = "application/json")
	public List<Teacher> searcheTeachers(@RequestParam("search") String searchCriteria ) throws SearchCriteraLangException {
		return teacherService.getTeachers(searchCriteria);
		
	}
}

// public String create(@RequestBody Teacher teacher) {
// service.save(teacher);
// }
