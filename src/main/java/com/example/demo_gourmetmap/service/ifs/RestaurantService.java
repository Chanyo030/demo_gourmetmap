package com.example.demo_gourmetmap.service.ifs;

import com.example.demo_gourmetmap.vo.GourmetMapRes;

public interface RestaurantService  {

	//�s�W
	public GourmetMapRes addRestaurant (String storeNameId, String city);
	
	//�ק�
	public GourmetMapRes updateRestaurant (String storeNameId, String city);
	
	//�R��
	public GourmetMapRes deleteRestaurant (String storeNameId, String city);
}
