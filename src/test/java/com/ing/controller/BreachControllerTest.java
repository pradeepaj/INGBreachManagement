package com.ing.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.dto.BreachDto;
import com.ing.dto.StatusReqDto;
import com.ing.dto.StatusResDto;
import com.ing.service.BreachService;

import junit.framework.TestCase;
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { TestCase.class, BreachController.class })
@WebAppConfiguration
public class BreachControllerTest {
	
	@InjectMocks
	private BreachController breachController;
	@Mock
	private BreachService breachService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(breachController).build();
	}

	
	
	@Test
	public void updateBreachStatusTest() throws JsonProcessingException, Exception {
		StatusResDto srd=new StatusResDto();
		srd.setMessage("success");
		srd.setStatusCode(200);
		List<StatusReqDto> prolist = new ArrayList<StatusReqDto>();
		StatusReqDto res=new StatusReqDto();
		res.setBreachId(1);
		res.setBusinessArea("private bank");
		res.setFranchise("cust");
        res.setStatus("open");		
        prolist.add(res);
		ResponseEntity<StatusResDto> expResult = new ResponseEntity<>(srd, HttpStatus.OK);
		
		when(breachService.updateBreachStatus(Mockito.anyObject())).thenReturn(srd);
		mockMvc.perform(post("bank/user/breach", "1").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(prolist))).andReturn();
		ResponseEntity<StatusResDto> actResult = breachController.updateBreachStatus(prolist);
		assertEquals(expResult, actResult);
	}
	
	@Test
	public void getBreachByTeamTest() throws JsonProcessingException, Exception {
		List<BreachDto> bd=new ArrayList<BreachDto>();
		BreachDto res=new BreachDto();
		res.setBreachId(1);
		res.setFranchise("private bank");
		res.setBusinessArea("customer service");
		res.setStatus("open");
		res.setStatusCode(200);
		bd.add(res);
         ResponseEntity<List<BreachDto>> expResult = new ResponseEntity<>(bd, HttpStatus.OK);
		
		when(breachService.getBreachByTeam(Mockito.anyString())).thenReturn(bd);
		mockMvc.perform(get("bank/user/{role}", "high").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(bd))).andReturn();
		ResponseEntity<List<BreachDto>> actResult = breachController.getBreachByTeam("high");
		assertEquals(expResult, actResult);
		
		
		
	}
	
	public static String asJsonString(final Object object) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(object);

	}
	
}
