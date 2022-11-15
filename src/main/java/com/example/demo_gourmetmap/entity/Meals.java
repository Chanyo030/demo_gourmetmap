package com.example.demo_gourmetmap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "meals")
@IdClass(value = MealsId.class)
public class Meals {

	@Id
	@Column(name = "meals_store_name_id")       //店名
	private String mealsStoreNameId;
	
	@Id
	@Column(name = "meals_id")                     //餐點
	private String mealsId;
	
	@Column(name = "price")                         //價格
	private int price;
	
	@Column(name = "meals_evaluation")          //評價
	private double mealsEvaluation;

	public Meals() {
		
	}

	public Meals(String mealsStoreNameId, String mealsId, int price, double mealsEvaluation) {
		this.mealsStoreNameId = mealsStoreNameId;
		this.mealsId = mealsId;
		this.price = price;
		this.mealsEvaluation = mealsEvaluation;
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
