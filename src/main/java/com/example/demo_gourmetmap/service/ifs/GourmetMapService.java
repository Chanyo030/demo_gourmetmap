package com.example.demo_gourmetmap.service.ifs;

import com.example.demo_gourmetmap.vo.GourmetMapRes;

public interface GourmetMapService  {

	//Restaurant
	//新增
	public GourmetMapRes addRestaurant (String storeNameId, String city);
	
	//修改
	public GourmetMapRes updateRestaurant (String storeNameId, String city);
	
	//刪除
	public GourmetMapRes deleteRestaurant (String storeNameId);
	
	//==========================================================
	//Meals
	//新增
		public GourmetMapRes addMeals (String mealsStoreNameId, String mealsId, int price);
		
		//修改
		public GourmetMapRes updateMeals (String mealsStoreNameId, String mealsId, int price);
		
		//刪除
		public GourmetMapRes deleteMeals (String mealsStoreNameId, String mealsId);
	
}
