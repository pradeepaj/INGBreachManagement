package com.ing.dto;



import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusResDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String message;

	private int statusCode;

}
