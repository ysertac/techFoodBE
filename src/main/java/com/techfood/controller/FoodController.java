package com.techfood.controller;

import com.techfood.entity.Food;
import com.techfood.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
@RestController
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> getAllFoods() {
        return foodService.findAll();
    }

    @GetMapping("/{id}")
    public Food getFood(@PathVariable long id) {
        return foodService.findById(id);
    }

    @PostMapping
    public Food createFood(@RequestBody Food food) {
        return foodService.save(food);
    }

    @PutMapping("/{id}")
    public Food updateFood(@RequestBody Food food, @PathVariable long id) {
        Food foundFood = foodService.findById(id);
        foundFood.setId(id);
        foundFood.setName(food.getName());
        foundFood.setImage(food.getImage());
        foundFood.setPoint(food.getPoint());
        foundFood.setDailyOrder(food.getDailyOrder());
        foundFood.setPrice(food.getPrice());
        foundFood.setDescription(food.getDescription());
        return foodService.save(foundFood);
    }

    @DeleteMapping("/{id}")
    public Food deleteFood(@PathVariable long id) {
        Food foundFood = foodService.findById(id);
        return foodService.delete(foundFood);
    }
}
