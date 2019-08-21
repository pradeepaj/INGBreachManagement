package com.ing.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.ing.dto.LoginResDto;
import com.ing.dto.StatusReqDto;
import com.ing.dto.StatusResDto;
import com.ing.entity.Breach;
import com.ing.repository.BreachRepository;
@RunWith(MockitoJUnitRunner.class)
public class BreachServiceImplTest {

	@Mock
	 BreachRepository breachRepository;
	@InjectMocks
	BreachServiceImpl breachService;
	
	
	@Test
	public void updateBreachStatusTest() {
		List<Breach> listBreach=new ArrayList<Breach>();
		StatusResDto result=new StatusResDto();
		result.setMessage("Status changed Successfully");
		result.setStatusCode(HttpStatus.OK.value());
		Breach breach=new Breach();
		breach.setBreachId(1);
		breach.setFranchise("private bank");
		breach.setBusinessArea("customer ");
		breach.setBreachCategory("other");
		listBreach.add(breach);
		List<StatusReqDto> srd=new ArrayList<StatusReqDto>();
		StatusReqDto sr=new StatusReqDto();
		sr.setBreachId(1);
		sr.setFranchise("private bank");
		sr.setBusinessArea("customer ");
		sr.setBreachCategory("other");
		srd.add(sr);
		//Mockito.when(breachRepository.saveAll(listBreach));
		Mockito.when(breachRepository.saveAll(listBreach)).thenReturn(listBreach);
		StatusResDto actualValue = breachService.updateBreachStatus(srd);
		
		
	}

}
