package com.freshgreen.entity;



import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {


	private Integer FlatNo;
	
	private String buildingName;
	
	private String  area;
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	
}
