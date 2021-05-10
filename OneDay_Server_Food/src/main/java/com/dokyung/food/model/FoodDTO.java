package com.dokyung.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
	
	String date;
	String fName;
	Integer qty;
	Integer gram;
	Integer kcal;
	Integer prot;
	Integer fat;
	Integer carbo;
	Integer sacc;

}
