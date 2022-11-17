package com.example.demo_gourmetmap.vo;

import com.example.demo_gourmetmap.entity.Meals;
import com.example.demo_gourmetmap.entity.Restaurant;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GourmetMapRes {
	
	private Restaurant restaurant;
	
	private Meals meals;

	// Restaurant �\�U

	private String storeNameId;      //���W

	private String city;                //����
	
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private double evaluation;       //����

	// ============================================================================
	// Meals �\�I

	private String mealsStoreNameId;      //���W

	private String mealsId;                   // �\�I

	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private int price;                          // ����

	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private double mealsEvaluation;        // ����

	// =============================================================================
	// �@�P���ܿ��~�T��
	private String message;
	
	// =============================================================================
	//GourmetMapRtnCode 
	public GourmetMapRes ( String message) {
		this.message = message;
	}

	
	//==============================================================================
	public GourmetMapRes() {

	}

	public GourmetMapRes(String storeNameId, String city, double evaluation, String mealsStoreNameId, String mealsId,
			int price, double mealsEvaluation, String message) {
		this.storeNameId = storeNameId;
		this.city = city;
		this.evaluation = evaluation;
		this.mealsStoreNameId = mealsStoreNameId;
		this.mealsId = mealsId;
		this.price = price;
		this.mealsEvaluation = mealsEvaluation;
		this.message = message;
	}	
	
	public Restaurant getRestaurant() {
		return restaurant;
	}


	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}


	public Meals getMeals() {
		return meals;
	}


	public void setMeals(Meals meals) {
		this.meals = meals;
	}


	public String getStoreNameId() {
		return storeNameId;
	}


	public void setStoreNameId(String storeNameId) {
		this.storeNameId = storeNameId;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public double getEvaluation() {
		return evaluation;
	}


	public void setEvaluation(double evaluation) {
		this.evaluation = evaluation;
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


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public double getMealsEvaluation() {
		return mealsEvaluation;
	}


	public void setMealsEvaluation(double mealsEvaluation) {
		this.mealsEvaluation = mealsEvaluation;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
}
