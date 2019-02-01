package com.hemanth.Controller;

import org.springframework.http.MediaType;


import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//import static org.junit.Assert.assertThat;

//import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertTrue;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hemanth.Controller.TeacherController;
import com.hemanth.Model.Teacher;
import com.hemanth.MongoInterface.MongoDBInteraction.MongoDbInteractionApplication;
import com.hemanth.Service.TeacherService;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoDbInteractionApplication.class)
@RunWith(MockitoJUnitRunner.class)
//@AutoConfigureMockMvc
//@SpringBootTest
//@WebAppConfiguration
@WebMvcTest(value = TeacherController.class, secure = false)
public class MongoDbInteractionApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	
	//@Autowired
	//private TeacherController teacherController;
	
	@Mock
	private TeacherService teacherService;
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllTeachers() throws Exception
	{
	Teacher mockTeacher1 = new Teacher("156", "Spring", "10 Steps", "9538169052");
	Teacher mockTeacher2 = new Teacher("157", "SpringBoot", "10 Steps", "9538169052");
	
	List<Teacher> teacherList = new ArrayList<>();
	
	teacherList.add(mockTeacher1);
	teacherList.add(mockTeacher2);

	System.out.println("Before Mockito");
	System.out.println("teacherService has "+teacherService);
	Mockito.when(teacherService.getAllTeachers()).thenReturn(teacherList);
	
	System.out.println("After Mockito");
	
	String URI = "/teachers";
	
	//RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
	
	System.out.println("Before MockMvc" +this.mockMvc);
	//MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	
	//MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	ResultActions actions = this.mockMvc.perform(get(URI));
	System.out.println("After MockMvc");
	
	//assertTrue(teacherController.getAllTeachers().size()==2);
	String expectedJson = this.mapToJson(teacherList);
	
	//String outputInJson = result.getResponse().getContentAsString();
	actions.andExpect(status().isOk());
	
	//System.out.println(teacherController.getAllTeachers().size());
	//assertThat(outputInJson).isEqualTo(expectedJson);
	
	//JSONAssert.assertEquals(expectedJson, actions.andExpect(status().isOk()), false);
	}
	
	
	@Test
	public void contextLoads() {
	}
	
	
	private String mapToJson(Object object) throws JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
	}



