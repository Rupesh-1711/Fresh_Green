package com.freshgreen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VegetableDto {

	private Integer vegId;
	private String name;

	private Double price;
	private Integer quantity;
}
