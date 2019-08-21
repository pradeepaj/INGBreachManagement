package com.ing.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreachReqDto {

	private long breachId;
	private String franchise;
	private String businessArea;
	private String breachCategory;
	private String priority;
	private String status;
	private String collegueFullName;
	private String supplier;
	private String nameReported;
	private String companyName;
	private String contactDetails;
	private LocalDate awareDate;
	private LocalDate breachDate;
	private String aware;
	private String awareMade;
	private String categerizeBreach;
	private String hasNumber;
	private String informationMisplaced;
	private String summaryBreach;
	private String breachLocation;
	private String franchiseCaused;
	private String buisnessCaused;
	private String customerBreachHappenned;
	private String customerName;
	private String informationCompromised;
	private long userId;
	
}
