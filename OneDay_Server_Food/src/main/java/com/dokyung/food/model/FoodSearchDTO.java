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
public class FoodSearchDTO {

	String fd_code;	//	식품코드	CHAR(7)
	String fd_name;	//	식품명	NVARCHAR2(200)
	String fd_date;	//	출시연도	CHAR(4)
	String cp_name;	//	제조사명	NVARCHAR2(125)
	String it_code;	//	분류코드	CHAR(4)
	String it_name;	//	분류명	NVARCHAR2(125)
	Integer fd_one;	//	회제공량	NUMBER
	Integer fd_gram;//	총내용량	NUMBER
	Integer fd_kcal;//	칼로리	NUMBER
	Integer fd_prot;//	단백질	NUMBER
	Integer fd_fat;	//	지방	NUMBER
	Integer carbo;	//	탄수화물	NUMBER
	Integer sacc;	//	총당류	NUMBER
}
