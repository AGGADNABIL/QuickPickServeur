package com.quick.pickup.test.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quick.pickup.controller.UserControllerRest;
import com.quick.pickup.entity.User;
import com.quick.pickup.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=UserControllerRest.class)
public class RestControllerTestUser {

	private Logger logger=LogManager.getLogger(RestControllerTestUser.class);
	@MockBean
	private UserService userService;
	@Autowired
	private MockMvc mockMvc;

	 
	@Test @Ignore
	public void testCreateUser() throws Exception{
		
		User user= new User("med", "med");
		String inputJson=this.mapToJson(user);
		String URI = "http://localhost:8080/profils/add";
		//User u=userDaoService.saveUser(user);
		//logger.info(u.toString());
		Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(user);
		//logger.info(u.toString());
		RequestBuilder requestBuilder=MockMvcRequestBuilders.post(URI)
											.accept(MediaType.APPLICATION_JSON)
											.content(inputJson)
											.contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult=mockMvc.perform(requestBuilder).andReturn();
		logger.info("mvcResult"+mvcResult);
		MockHttpServletResponse response =mvcResult.getResponse();
		
		String outputInjson = response.getContentAsString();
		assertThat(outputInjson).isEqualTo(inputJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
	}
	
	@Test //@Ignore
	public void testGetAllUser() throws Exception {
		List<User> listUser=userService.findAllUser();
		Mockito.when(userService.findAllUser()).thenReturn(listUser);
		String URI="http://localhost:8080/profils";
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get(
				URI).accept(MediaType.APPLICATION_JSON);
		
		MvcResult result =mockMvc.perform(requestBuilder).andReturn();
		String exceptedJson=this.mapToJson(listUser);
		String outputInjson = result.getResponse().getContentAsString();
		
		assertThat(outputInjson).isEqualTo(exceptedJson);
	}

	private String mapToJson(Object o) throws JsonProcessingException {
		ObjectMapper objectMapper=new ObjectMapper();
		
		return objectMapper.writeValueAsString(o);
	}
	
	@Test @Ignore
	public void testDeleteUserByUsername() throws Exception {
		User user =userService.findUser("ach");
		Mockito.when(userService.deleteUser("ach")).thenReturn(user);
		String URI = "http://localhost:8080/profils/ach";
		String inputJson=this.mapToJson(user);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.delete(URI)
															.accept(MediaType.APPLICATION_JSON)
															.content(inputJson)
															.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response =result.getResponse();
		String outputInJson=response.getContentAsString();
		//assertThat(outputInJson).isEqualTo(inputJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
	}
	
	@Test @Ignore
	public void testUpdateUser() throws Exception {
		/* 
		 
		User updated=new User("nabil", "char");
		Mockito.when(userService.updateUser(user)).thenReturn(updated);
		String URI = "http://localhost:8080/profils/nabil";
		String inputJson=this.mapToJson(updated);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.put(URI)
															.accept(MediaType.APPLICATION_JSON)
															.content(inputJson)
															.contentType(MediaType.APPLICATION_JSON);
		 mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status()
                .isOk())
		 		.andExpect(MockMvcResultMatchers.content()
                .string("Article created."))
		 		.andDo(MockMvcResultHandlers.print());
		 		*/
				
		//.andReturn();
		//MockHttpServletResponse response =result.getResponse();
		
		
		//String outputInJson=response.getContentAsString();
		//assertThat(outputInJson).isEqualTo(inputJson);
		//assertEquals(HttpStatus.OK.value(), response.getStatus());
		//========================
		 
			User user= new User("nabil", "med");
			String inputJson=this.mapToJson(user);
		/*	String URI = "http://localhost:8080/profils/nabil";
			//User u=userDaoService.saveUser(user);
			//logger.info(u.toString());
			Mockito.when(userService.updateUser(Mockito.any(User.class))).thenReturn(user);
			//logger.info(u.toString());
			RequestBuilder requestBuilder=MockMvcRequestBuilders.post(URI)
												.accept(MediaType.APPLICATION_JSON)
												.content(inputJson)
												.contentType(MediaType.APPLICATION_JSON);
			MvcResult mvcResult=mockMvc.perform(requestBuilder).andReturn();
			logger.info("mvcResult"+mvcResult);
			MockHttpServletResponse response =mvcResult.getResponse();
			
			String outputInjson = response.getContentAsString();
			assertThat(outputInjson).isEqualTo(inputJson);
			assertEquals(HttpStatus.OK.value(), response.getStatus());
			*/
			
			
			Mockito.when(userService.findUser(user.getUsername())).thenReturn(user);
			Mockito.when(userService.updateUser(user)).thenReturn(user);
		    mockMvc.perform(
		            put("/profils/{username:.+}", user.getUsername())
		                    .contentType(MediaType.APPLICATION_JSON)
		                    .content(inputJson))
		            .andExpect(status().isOk());
		    Mockito.verify(userService).findUser(user.getUsername());
		    Mockito.verify(userService).updateUser(user);
		    Mockito.verifyNoMoreInteractions(userService);
	}
	
	@Test
	public void testUpdateById() throws Exception {
		User updated=new User(2 ,"nabil", "char");
		User user=new User(2, "nabil", "nabil");
		Mockito.when(userService.updateUser(user)).thenReturn(updated);
		String URI = "http://localhost:8080/profils/2";
		String inputJson=this.mapToJson(updated);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.put(URI)
															.accept(MediaType.APPLICATION_JSON)
															.content(inputJson)
															.contentType(MediaType.APPLICATION_JSON);
		 mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status()
                .isOk())
		 		.andExpect(MockMvcResultMatchers.content()
                .string("Article updated."))
		 		.andDo(MockMvcResultHandlers.print());
		 		
				
		//.andReturn();
		//MockHttpServletResponse response =result.getResponse();
		
		
		//String outputInJson=response.getContentAsString();
		//assertThat(outputInJson).isEqualTo(inputJson);
		//assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
}
