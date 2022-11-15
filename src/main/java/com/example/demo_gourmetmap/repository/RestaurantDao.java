package com.example.demo_gourmetmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_gourmetmap.entity.Restaurant;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, String> {

}
