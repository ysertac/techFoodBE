package com.techfood.service;

import com.techfood.entity.Food;
import com.techfood.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Food findById(long id) {
        Optional<Food> optionalFood = foodRepository.findById(id);
        if (optionalFood.isEmpty()) {
            throw new RuntimeException("This product does not exist!");
        }
        return optionalFood.get();
    }

    @Override
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food delete(Food food) {
        foodRepository.delete(food);
        return food;
    }
}
