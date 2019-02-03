package com.hemanth.Controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.file.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hemanth.Model.Teacher;
import com.hemanth.MongoInterface.MongoDBInteraction.MongoDbInteractionApplication;
import com.hemanth.Service.TeacherService;
import com.hemanth.config.Config;
import com.hemanth.config.TestConfig;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@WebMvcTest(controllers = TeacherController.class)
public class MongoDbInteractionApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TeacherService teacherService;
	
	
	//@Autowired
	//private TeacherController teacherController;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllTeachers() throws Exception {
		
		Teacher mockTeacher1 = new Teacher("156", "Spring", "10 Steps", "9538169052");
		Teacher mockTeacher2 = new Teacher("157", "SpringBoot", "10 Steps", "9538169052");
		
		
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList .add(mockTeacher1);
		teacherList.add(mockTeacher2);
	
		Mockito.when(teacherService.getAllTeachers()).thenReturn(teacherList);
		mockMvc.perform(MockMvcRequestBuilders.get("/teachers"))
				      .andExpect(MockMvcResultMatchers.status().isOk())
				      .andExpect(MockMvcResultMatchers.content()
				      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				      .andExpect(jsonPath("$[0].id", is(teacherList.get(0).getId())))
				      .andExpect(jsonPath("$[1].id", is(teacherList.get(1).getId())));
		
	}
	
	@Test
	public void testRegisterTeachers() throws Exception {
		
		Teacher mockTeacher1 = new Teacher("156", "Spring", "10 Steps", "9538169052");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(mockTeacher1);
		
	
		mockMvc.perform(MockMvcRequestBuilders.post("/teachers").content(json).contentType(MediaType.APPLICATION_JSON))
				      .andExpect(MockMvcResultMatchers.status().isOk());
		
		Mockito.verify(teacherService).saveTeacher(mockTeacher1);


	}
	
	
	@Test
	public void testDeleteTeacher() throws Exception {
		
        Teacher mockTeacher1 = new Teacher("156", "Spring", "10 Steps", "9538169052");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(mockTeacher1);
		
	
		mockMvc.perform(MockMvcRequestBuilders.delete("/teachers/156").content(json).contentType(MediaType.APPLICATION_JSON))
				      .andExpect(MockMvcResultMatchers.status().isOk());
		
		Mockito.verify(teacherService).deleteTeacher("156");

		
		}
	
	
	@Test
	public void testUpdateTeacherDetails() throws Exception {
		
		Teacher mockTeacher1 = new Teacher("156", "Spring", "10 Steps", "9538169052");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(mockTeacher1);
		
	
		mockMvc.perform(MockMvcRequestBuilders.put("/teachers").content(json).contentType(MediaType.APPLICATION_JSON))
				      .andExpect(MockMvcResultMatchers.status().isOk());
		
		Mockito.verify(teacherService).updateTeacher(mockTeacher1);


		
	}
	
	
	}



