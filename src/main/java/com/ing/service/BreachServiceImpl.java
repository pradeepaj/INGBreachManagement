package com.ing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ing.dto.BreachDto;
import com.ing.dto.BreachReqDto;
import com.ing.dto.BuisnessAreaDTO;
import com.ing.dto.StatusReqDto;
import com.ing.dto.StatusResDto;
import com.ing.entity.Breach;
import com.ing.entity.BuisnessArea;
import com.ing.entity.RuleEngine;
import com.ing.entity.UserDetails;
import com.ing.exception.BreachManagementException;
import com.ing.repository.BreachRepository;
import com.ing.repository.BuisnessReppository;
import com.ing.repository.RuleEngineRepository;
import com.ing.repository.UserRepository;
@Service
public class BreachServiceImpl implements BreachService {

	@Autowired
	private BreachRepository breachRepository;

	@Autowired
	UserRepository userRepo;

	@Autowired
	RuleEngineRepository ruleEngineRepo;
	
	@Autowired
	BuisnessReppository buisnessRepo;

	
	@Override
	public StatusResDto updateBreachStatus(List<StatusReqDto> statusReqDto) {
		
		List<Breach> listBreach=new ArrayList<Breach>();
		statusReqDto.forEach(sr->{
			
			Breach breach=new Breach();
			breach.setBreachId(sr.getBreachId());
			breach.setStatus(sr.getStatus());
			breach.setFranchise(sr.getFranchise());
			breach.setBusinessArea(sr.getBusinessArea());
			breach.setBreachCategory(sr.getBreachCategory());
			listBreach.add(breach);
			
		});
		
		breachRepository.saveAll(listBreach);
		StatusResDto result=new StatusResDto();
		result.setMessage("Status changed Successfully");
		result.setStatusCode(HttpStatus.OK.value());
		return result;
	}

	@Override
	public List<BreachDto> getBreachByTeam(String role) {
		List<Breach> breachList=breachRepository.findByPriority(role);
		List<BreachDto> listBreach=new ArrayList<BreachDto>();
		breachList.forEach(bl->{
			BreachDto bd=new BreachDto();
			bd.setBreachId(bl.getBreachId());
			bd.setFranchise(bl.getFranchise());
			bd.setBusinessArea(bl.getBusinessArea());
			bd.setBreachCategory(bl.getBreachCategory());
			bd.setStatus(bl.getStatus());
			bd.setStatusCode(HttpStatus.OK.value());
			listBreach.add(bd);
		});
		
		return listBreach;
	}
	
	public String createBreach(BreachReqDto breachDTO) {

		if (null != breachDTO) {
			Breach breach = new Breach();
			BeanUtils.copyProperties(breachDTO, breach);
			RuleEngine ruleEngine = ruleEngineRepo.findByBreachCategoryAndBusinessAreaAndFranchise(
					breachDTO.getBreachCategory(), breachDTO.getBusinessArea(), breachDTO.getFranchise());
			if (null != ruleEngine) {
				breach.setPriority((ruleEngine.getRiskProfile()));
				breach.setStatus("open");
			}
			else {
				breach.setStatus("low");
			}

			UserDetails userDetails = userRepo.findById(breachDTO.getUserId()).get();
			breach.setUserDetails(userDetails);
			// System.out.println(breachDTO);
			// System.out.println(breach.toString());
			breach.getUserDetails();
			breach = breachRepository.save(breach);
			return "Breach Created";
		} else {
			throw new BreachManagementException("Please enter Valid breach Item");
		}
	}
	public List<BuisnessAreaDTO> buisnessArea(Integer id) {

		List<BuisnessArea> buisnessArea = buisnessRepo.findByfid(id);
		List<BuisnessAreaDTO> buisnessDTOList = new ArrayList<BuisnessAreaDTO>();

		for(BuisnessArea buisness: buisnessArea) {
			BuisnessAreaDTO bDTO = new BuisnessAreaDTO();
			bDTO.setName(buisness.getBuisnessArea());
			bDTO.setValue(buisness.getId());
			buisnessDTOList.add(bDTO);
		}
		return buisnessDTOList;
	}
	

}
