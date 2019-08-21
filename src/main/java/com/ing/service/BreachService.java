package com.ing.service;

import java.util.List;

import com.ing.dto.BreachDto;
import com.ing.dto.BreachReqDto;
import com.ing.dto.BuisnessAreaDTO;
import com.ing.dto.StatusReqDto;
import com.ing.dto.StatusResDto;

public interface BreachService {

	StatusResDto updateBreachStatus(List<StatusReqDto> statusReqDto);

	List<BreachDto> getBreachByTeam(String role);

	String createBreach(BreachReqDto breach);
	
	public List<BuisnessAreaDTO> buisnessArea(Integer id);

}
