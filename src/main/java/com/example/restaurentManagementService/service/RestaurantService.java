package com.example.restaurentManagementService.service;

import com.example.restaurentManagementService.model.Food;
import com.example.restaurentManagementService.model.Restaurant;
import com.example.restaurentManagementService.model.RestaurantManagement;
import com.example.restaurentManagementService.repository.IRestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private IRestaurantRepository iRestaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurantList = iRestaurantRepository.findAll();
        return restaurantList;
    }

    public Restaurant getRestaurantById(Long id) {
        return iRestaurantRepository.findByRestaurantId(id);
    }

    @Transactional
    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
        Restaurant existingRestaurant = getRestaurantById(id);
        if(restaurant.getRestaurantName() != null) {
            existingRestaurant.setRestaurantName(restaurant.getRestaurantName());
        }
        List<Food> foodList = restaurant.getMenu();
        for(Food food : foodList){
            food.setRestaurant(restaurant);
        }
        RestaurantManagement restaurantManagement = restaurant.getPersonalDetails();
        restaurantManagement.setRestaurant(restaurant);
        return iRestaurantRepository.save(existingRestaurant);
    }

    @Transactional
    public void deleteRestaurant(Long id) {
        iRestaurantRepository.deleteByRestaurantId(id);
    }

    public void saveRestaurantDetails(Restaurant restaurant) {
        List<Food> foodList = restaurant.getMenu();
        for(Food food : foodList){
            food.setRestaurant(restaurant);
        }
        RestaurantManagement restaurantManagement = restaurant.getPersonalDetails();
        restaurantManagement.setRestaurant(restaurant);
        iRestaurantRepository.save(restaurant);
    }
}
