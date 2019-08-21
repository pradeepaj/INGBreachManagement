package com.ing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Franchise {
	
	@Id
	@GeneratedValue
	private int id;
	private String franchise;

}
