package com.example.demo_gourmetmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_gourmetmap.entity.Meals;
import com.example.demo_gourmetmap.entity.MealsId;

@Repository
public interface MealsDao extends JpaRepository<Meals, MealsId> {

}
