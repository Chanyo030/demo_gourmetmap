package com.example.demo_gourmetmap.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo_gourmetmap.constants.GourmetMapRtnCode;
import com.example.demo_gourmetmap.entity.Restaurant;
import com.example.demo_gourmetmap.repository.MealsDao;
import com.example.demo_gourmetmap.repository.RestaurantDao;
import com.example.demo_gourmetmap.service.ifs.RestaurantService;
import com.example.demo_gourmetmap.vo.GourmetMapRes;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDao restaurantDao;

	private MealsDao mealsDao;

	@Override
	// 新增
	public GourmetMapRes addRestaurant(String storeNameId, String city) {
		
		if (!StringUtils.hasText(storeNameId)) { // 店名為空
			return new GourmetMapRes(GourmetMapRtnCode.NO_DATA.getMessage());
		}
		
		if (!StringUtils.hasText(city)) { // 城市為空
			return new GourmetMapRes (GourmetMapRtnCode.NO_DATA.getMessage());
		}
		
		GourmetMapRes gourmstMapRes = new GourmetMapRes();
		Optional<Restaurant> restaurantOp = restaurantDao.findById(storeNameId);
//		if (restaurantOp.orElse(null) != null) { // 店名已存在
			if(restaurantOp.isPresent()) {
			return new GourmetMapRes(GourmetMapRtnCode.STORE_NAME_EXISTED.getMessage());
		}
		
		Restaurant restaurant = new Restaurant(storeNameId, city);
		restaurantDao.save(restaurant);
		gourmstMapRes.setRestaurant(restaurant);
		gourmstMapRes.setMessage(GourmetMapRtnCode.SUCCESSFUL.getMessage());
		return gourmstMapRes;
	}
	
//===================================================================================
	//修改
	@Override
	public GourmetMapRes updateRestaurant(String storeNameId, String city) {
		
		if (!StringUtils.hasText(storeNameId)) { // 店名為空
			return new GourmetMapRes(GourmetMapRtnCode.NO_DATA.getMessage());
		}
		
		if (!StringUtils.hasText(city)) { // 城市為空
			return new GourmetMapRes (GourmetMapRtnCode.NO_DATA.getMessage());
		}
		
		GourmetMapRes gourmetMapRes = new GourmetMapRes();
		Optional<Restaurant> restaurantOp = restaurantDao.findById(storeNameId);
//		if (restaurantOp.orElse(null) != null) {           // 查無此店(店不存在)
			if(!restaurantOp.isPresent()) {
			return new GourmetMapRes(GourmetMapRtnCode.NO_DATA.getMessage());
		}else {
			Restaurant updatRestaurant = restaurantOp.get();
			updatRestaurant.setStoreNameId(storeNameId);
			updatRestaurant.setCity(city);
			restaurantDao.save(updatRestaurant);
			gourmetMapRes.setMessage(GourmetMapRtnCode.UPDATE_SUCCESSFUL.getMessage());
			return gourmetMapRes;
		}	
	}

	
	//刪除
	@Override
	public GourmetMapRes deleteRestaurant(String storeNameId, String city) {
		// TODO Auto-generated method stub
		return null;
	}

}
