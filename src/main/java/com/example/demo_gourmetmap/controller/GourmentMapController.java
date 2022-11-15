package com.example.demo_gourmetmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_gourmetmap.service.ifs.RestaurantService;
import com.example.demo_gourmetmap.vo.GourmetMapRes;
import com.example.demo_gourmetmap.vo.GourmetMapReq;

@RestController
public class GourmentMapController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping(value = "/api/addRestaurant")
	public GourmetMapRes addRestaurant (@RequestBody GourmetMapReq req) {
		GourmetMapRes gourmstMapRes = new GourmetMapRes();
		gourmstMapRes = restaurantService.addRestaurant(req.getStoreNameId(), req.getCity());
		return gourmstMapRes;
	}

	@PostMapping(value = "updateRestaurant")
	public GourmetMapRes updateRestaurant (@RequestBody GourmetMapReq req) {
		GourmetMapRes gourmetMapRes = new GourmetMapRes();
		gourmetMapRes = restaurantService.updateRestaurant(req.getStoreNameId(), req.getCity());
		return gourmetMapRes;
	}
}
