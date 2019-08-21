package com.ing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ing.dto.BreachDto;
import com.ing.dto.BreachReqDto;
import com.ing.dto.BuisnessAreaDTO;
import com.ing.dto.StatusReqDto;
import com.ing.dto.StatusResDto;
import com.ing.exception.ErrorResponse;
import com.ing.service.BreachService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class BreachController {
	
	@Autowired
	private BreachService breachService;
	
	@PostMapping("user/breach")
	public ResponseEntity<StatusResDto> updateBreachStatus(@RequestBody List<StatusReqDto> statusReqDto )
	{

		return new ResponseEntity<>(breachService.updateBreachStatus(statusReqDto),HttpStatus.OK);
	}
	
	@GetMapping("user/breach/{role}")
	public ResponseEntity<List<BreachDto>> getBreachByTeam(@PathVariable String role){
		return new ResponseEntity<>(breachService.getBreachByTeam(role),HttpStatus.OK);
		
	}
	

	@PostMapping("/user/breach/create")
	public ResponseEntity<ErrorResponse> createBreach(@RequestBody BreachReqDto breach){
		ErrorResponse response = new ErrorResponse();
		response.setMessage(breachService.createBreach(breach));
		response.setStatusCode(201);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/buisnessarea/{id}")
	public ResponseEntity<List<BuisnessAreaDTO>> getRuleEngineDetails(@PathVariable Integer id) {
		List<BuisnessAreaDTO> buisnessAreaDTO = breachService.buisnessArea(id);
		return new ResponseEntity<List<BuisnessAreaDTO>>(buisnessAreaDTO, HttpStatus.OK);
		/*
		 * ErrorResponse response = new ErrorResponse();
		 * response.setMessage(breachService.getRules()); response.setStatusCode(200);
		 * return new ResponseEntity<ErrorResponse>(response, HttpStatus.OK);
		 */

	}

}
