package com.example.demo_gourmetmap.vo;

import com.example.demo_gourmetmap.entity.Restaurant;

public class GourmetMapReq {

	private Restaurant restaurant;

	// Restaurant 餐廳

	private String storeNameId;      //店名

	private String city;                //城市

	private double evaluation;       //評價

	// ============================================================================
	// Meals 餐點

	private String mealsStoreNameId;      //店名

	private String mealsId;                   // 餐點

	private int price;                          // 價格

	private double mealsEvaluation;        // 評價
	
	//==============================================================================
	public GourmetMapReq() {

	}

	public GourmetMapReq(String storeNameId, String city, double evaluation, String mealsStoreNameId, String mealsId,
			int price, double mealsEvaluation) {
		this.storeNameId = storeNameId;
		this.city = city;
		this.evaluation = evaluation;
		this.mealsStoreNameId = mealsStoreNameId;
		this.mealsId = mealsId;
		this.price = price;
		this.mealsEvaluation = mealsEvaluation;
	}	
	
	public Restaurant getRestaurant() {
		return restaurant;
	}


	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
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
}
