package com.example.demo_gourmetmap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

	@Id
	@Column(name = "store_name_id")         //©±¦W
	private String storeNameId;
	
	@Column(name = "city")                     //«°¥«
	private String city;
	
	@Column(name = "evaluation")             //µû»ù
	private double evaluation;

	public Restaurant() {
		
	}

	public Restaurant(String storeNameId, String city) {
		this.storeNameId = storeNameId;
		this.city = city;
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
}
