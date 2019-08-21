package com.ing.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusReqDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private long breachId;
	private String franchise;
	private String businessArea;
	private String breachCategory;
	private String status;
}
