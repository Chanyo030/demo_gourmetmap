package com.example.demo_gourmetmap.service.ifs;

import com.example.demo_gourmetmap.vo.GourmetMapRes;

public interface RestaurantService  {

	//新增
	public GourmetMapRes addRestaurant (String storeNameId, String city);
	
	//修改
	public GourmetMapRes updateRestaurant (String storeNameId, String city);
	
	//刪除
	public GourmetMapRes deleteRestaurant (String storeNameId, String city);
}
