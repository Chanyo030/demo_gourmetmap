package com.example.demo_gourmetmap.service.ifs;

import com.example.demo_gourmetmap.vo.GourmetMapRes;

public interface GourmetMapService  {

	//Restaurant
	//�s�W
	public GourmetMapRes addRestaurant (String storeNameId, String city);
	
	//�ק�
	public GourmetMapRes updateRestaurant (String storeNameId, String city);
	
	//�R��
	public GourmetMapRes deleteRestaurant (String storeNameId);
	
	//==========================================================
	//Meals
	//�s�W
		public GourmetMapRes addMeals (String mealsStoreNameId, String mealsId, int price);
		
		//�ק�
		public GourmetMapRes updateMeals (String mealsStoreNameId, String mealsId, int price);
		
		//�R��
		public GourmetMapRes deleteMeals (String mealsStoreNameId, String mealsId);
	
}
