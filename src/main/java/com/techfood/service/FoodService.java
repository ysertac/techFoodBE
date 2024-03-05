package com.techfood.service;

import com.techfood.entity.Food;

import java.util.List;

public interface FoodService {
    List<Food> findAll();
    Food findById(long id);
    Food save(Food food);
    Food delete(Food food);
}
