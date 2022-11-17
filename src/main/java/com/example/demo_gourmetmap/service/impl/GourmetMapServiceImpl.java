package com.example.demo_gourmetmap.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo_gourmetmap.constants.GourmetMapRtnCode;
import com.example.demo_gourmetmap.entity.Meals;
import com.example.demo_gourmetmap.entity.MealsId;
import com.example.demo_gourmetmap.entity.Restaurant;
import com.example.demo_gourmetmap.repository.MealsDao;
import com.example.demo_gourmetmap.repository.RestaurantDao;
import com.example.demo_gourmetmap.service.ifs.GourmetMapService;
import com.example.demo_gourmetmap.vo.GourmetMapRes;

@Service    // 讓Spring Boot託管 這樣才有辦法在其他地方被@Autowired
public class GourmetMapServiceImpl implements GourmetMapService {

	@Autowired   //依賴    預設會依注入對象的類別型態來選擇容器中相符的物件來注入。
	private RestaurantDao restaurantDao;

	private MealsDao mealsDao;

	/* Restaurant */
	@Override
	// 新增
	public GourmetMapRes addRestaurant(String storeNameId, String city) {

		if (!StringUtils.hasText(storeNameId) || !StringUtils.hasText(city) ) {  // 店名、城市為空
			return new GourmetMapRes(GourmetMapRtnCode.NOT_NULL.getMessage());
		}

		GourmetMapRes gourmstMapRes = new GourmetMapRes();
		Optional<Restaurant> restaurantOp = restaurantDao.findById(storeNameId);
//		if (restaurantOp.orElse(null) != null) { // 店名已存在
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
	// 修改
	@Override
	public GourmetMapRes updateRestaurant(String storeNameId, String city) {

		if (!StringUtils.hasText(storeNameId) || !StringUtils.hasText(city)) { // 店名、城市為空
			return new GourmetMapRes(GourmetMapRtnCode.NOT_NULL.getMessage());
		}

		GourmetMapRes gourmetMapRes = new GourmetMapRes();
		Optional<Restaurant> restaurantOp = restaurantDao.findById(storeNameId);
//		if (restaurantOp.orElse(null) != null) {           // 查無此店(店不存在)
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
	// 刪除
	@Override
	public GourmetMapRes deleteRestaurant(String storeNameId) {
		if (!StringUtils.hasText(storeNameId)) { // 店名為空
			return new GourmetMapRes(GourmetMapRtnCode.NOT_NULL.getMessage());
		}

		Optional<Restaurant> restaurantOp = restaurantDao.findById(storeNameId);
		if (!restaurantOp.isPresent()) { // 查無此店(不存在)
			return new GourmetMapRes(GourmetMapRtnCode.NO_DATA.getMessage());
		}

		restaurantDao.deleteById(storeNameId);
		return new GourmetMapRes(GourmetMapRtnCode.DELETE_SUCCESSFUL.getMessage());
	}

	/* Meals */
	// 新增
	@Override
	public GourmetMapRes addMeals(String mealsStoreNameId, String mealsId, int price) {
		
		//店名、餐點名稱、價格為空
		if(!StringUtils.hasText(mealsStoreNameId) || !StringUtils.hasText(mealsId) || price == 0) {  
			return new GourmetMapRes(GourmetMapRtnCode.NOT_NULL.getMessage());
		}
		
		MealsId mealsIdClass = new MealsId(mealsStoreNameId, mealsId);        //取得複合主鍵的內容
		Optional<Meals> mealsIdOp = mealsDao.findById(mealsIdClass);          //再看DB裡是否有複合主鍵這兩個東西
		if(mealsIdOp.isPresent()) {                    //有，那就去判斷店名、餐點是否存在(重複)
			return new GourmetMapRes(GourmetMapRtnCode.STORE_NAME_AND_MEALS_EXISTED.getMessage());
		}
		
		Meals meale = new Meals(mealsStoreNameId, mealsId, price);
		mealsDao.save(meale);
		GourmetMapRes gourmetMapRes = new GourmetMapRes();
		gourmetMapRes.setMeals(meale);
		return gourmetMapRes;
	}

	// ========================================================================
	// 修改
	@Override
	public GourmetMapRes updateMeals(String mealsStoreNameId, String mealsId, int price) {
		// TODO Auto-generated method stub
		return null;
	}

	// ========================================================================
	// 刪除
	@Override
	public GourmetMapRes deleteMeals(String mealsStoreNameId, String mealsId) {
		// TODO Auto-generated method stub
		return null;
	}

}
