package com.example.demo_gourmetmap.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MealsId implements Serializable {

	private String mealsStoreNameId;

	private String mealsId;
	
	public MealsId() {
		
	}

	public MealsId(String mealsStoreNameId, String mealsId) {
		this.mealsStoreNameId = mealsStoreNameId;
		this.mealsId = mealsId;
	}

	public String getMealsStoreNameId() {
		return mealsStoreNameId;
	}

	public void setMealsStoreNameId(String mealsStoreNameId) {
		this.mealsStoreNameId = mealsStoreNameId;
	}

	public String getMealsId() {
		return mealsId;
	}

	public void setMealsId(String mealsId) {
		this.mealsId = mealsId;
	}
}
