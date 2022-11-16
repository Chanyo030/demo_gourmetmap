package com.example.demo_gourmetmap.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo_gourmetmap.constants.GourmetMapRtnCode;
import com.example.demo_gourmetmap.entity.Meals;
import com.example.demo_gourmetmap.entity.Restaurant;
import com.example.demo_gourmetmap.repository.MealsDao;
import com.example.demo_gourmetmap.repository.RestaurantDao;
import com.example.demo_gourmetmap.service.ifs.GourmetMapService;
import com.example.demo_gourmetmap.vo.GourmetMapRes;

@Service
public class GourmetMapServiceImpl implements GourmetMapService {

	@Autowired
	private RestaurantDao restaurantDao;

	private MealsDao mealsDao;

	/* Restaurant */
	@Override
	// �s�W
	public GourmetMapRes addRestaurant(String storeNameId, String city) {

		if (!StringUtils.hasText(storeNameId)) { // ���W����
			return new GourmetMapRes(GourmetMapRtnCode.NOT_NULL.getMessage());
		}

		if (!StringUtils.hasText(city)) { // ��������
			return new GourmetMapRes(GourmetMapRtnCode.NOT_NULL.getMessage());
		}

		GourmetMapRes gourmstMapRes = new GourmetMapRes();
		Optional<Restaurant> restaurantOp = restaurantDao.findById(storeNameId);
//		if (restaurantOp.orElse(null) != null) { // ���W�w�s�b
		if (restaurantOp.isPresent()) {
			return new GourmetMapRes(GourmetMapRtnCode.STORE_NAME_EXISTED.getMessage());
		}

		Restaurant restaurant = new Restaurant(storeNameId, city);
		restaurantDao.save(restaurant);
		gourmstMapRes.setRestaurant(restaurant);
		gourmstMapRes.setMessage(GourmetMapRtnCode.SUCCESSFUL.getMessage());
		return gourmstMapRes;
	}

//===================================================================================
	// �ק�
	@Override
	public GourmetMapRes updateRestaurant(String storeNameId, String city) {

		if (!StringUtils.hasText(storeNameId)) { // ���W����
			return new GourmetMapRes(GourmetMapRtnCode.NOT_NULL.getMessage());
		}

		if (!StringUtils.hasText(city)) { // ��������
			return new GourmetMapRes(GourmetMapRtnCode.NOT_NULL.getMessage());
		}

		GourmetMapRes gourmetMapRes = new GourmetMapRes();
		Optional<Restaurant> restaurantOp = restaurantDao.findById(storeNameId);
//		if (restaurantOp.orElse(null) != null) {           // �d�L����(�����s�b)
		if (!restaurantOp.isPresent()) {
			return new GourmetMapRes(GourmetMapRtnCode.NO_DATA.getMessage());
		} else {
			Restaurant updatRestaurant = restaurantOp.get();
			updatRestaurant.setStoreNameId(storeNameId);
			updatRestaurant.setCity(city);
			restaurantDao.save(updatRestaurant);
			gourmetMapRes.setMessage(GourmetMapRtnCode.UPDATE_SUCCESSFUL.getMessage());
			return gourmetMapRes;
		}
	}

//==============================================================================
	// �R��
	@Override
	public GourmetMapRes deleteRestaurant(String storeNameId) {
		if (!StringUtils.hasText(storeNameId)) { // ���W����
			return new GourmetMapRes(GourmetMapRtnCode.NOT_NULL.getMessage());
		}

		Optional<Restaurant> restaurantOp = restaurantDao.findById(storeNameId);
		if (!restaurantOp.isPresent()) { // �d�L����(���s�b)
			return new GourmetMapRes(GourmetMapRtnCode.NO_DATA.getMessage());
		}

		restaurantDao.deleteById(storeNameId);
		return new GourmetMapRes(GourmetMapRtnCode.DELETE_SUCCESSFUL.getMessage());
	}

	/* Meals */
	// �s�W
	@Override
	public GourmetMapRes addMeals(String mealsStoreNameId, String mealsId, int price) {
		if(!StringUtils.hasText(mealsStoreNameId)) {                  //���W����
			return new GourmetMapRes(GourmetMapRtnCode.NOT_NULL.getMessage());
		}
		
		if(!StringUtils.hasText(mealsId)) {                               //�\�I�W�٬���
			return new GourmetMapRes(GourmetMapRtnCode.NOT_NULL.getMessage());
		}
		
		if(price == 0) {                                                     //���欰��
			return new GourmetMapRes(GourmetMapRtnCode.NOT_NULL.getMessage());
		}
		
//		Optional<Meals> mealsOp = mealsDao.findAllById(mealsStoreNameId, mealsId);
		List <Meals> mealsList = mealsDao.findAllById(mealsStoreNameId, mealsId);
		
		Meals meals = new Meals();
		meals.setMealsStoreNameId(mealsStoreNameId);
		meals.setMealsId(mealsId);
		meals.setPrice(price);

		return null;
	}

	// ========================================================================
	// �ק�
	@Override
	public GourmetMapRes updateMeals(String mealsStoreNameId, String mealsId, int price) {
		// TODO Auto-generated method stub
		return null;
	}

	// ========================================================================
	// �R��
	@Override
	public GourmetMapRes deleteMeals(String mealsStoreNameId, String mealsId) {
		// TODO Auto-generated method stub
		return null;
	}

}
