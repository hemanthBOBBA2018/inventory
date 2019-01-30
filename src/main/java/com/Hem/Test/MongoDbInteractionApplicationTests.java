package com.hemanth.MongoInterface.MongoDBInteraction;

import org.springframework.http.MediaType;

//import static org.junit.Assert.assertThat;

//import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hemanth.Controller.TeacherController;
import com.hemanth.Model.Teacher;
import com.hemanth.Service.TeacherService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TeacherController.class, secure = false)
public class MongoDbInteractionApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TeacherService teacherService;
	
	@Test
	public void testGetAllTeachers() throws Exception
	{
	Teacher mockTeacher1 = new Teacher("156", "Spring", "10 Steps", "9538169052");
	Teacher mockTeacher2 = new Teacher("157", "SpringBoot", "10 Steps", "9538169052");
	
	List<Teacher> teacherList = new ArrayList<>();
	
	teacherList.add(mockTeacher1);
	teacherList.add(mockTeacher2);
	
	Mockito.when(teacherService.getAllTeachers()).thenReturn(teacherList);
	
	String URI = "/teachers";
	
	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
	
	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	
	String expectedJson = this.mapToJson(teacherList);
	String outputInJson = result.getResponse().getContentAsString();
	
	//assertThat(outputInJson).isEqualTo(expectedJson);
	
	JSONAssert.assertEquals(expectedJson, outputInJson, false);
	}
	
	
	@Test
	public void contextLoads() {
	}
	
	private String mapToJson(Object object) throws JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	}



