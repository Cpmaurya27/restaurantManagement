package com.example.restaurentManagementService.repository;

import com.example.restaurentManagementService.model.Restaurant;
import com.example.restaurentManagementService.model.RestaurantManagement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantManagementRepository extends JpaRepository<RestaurantManagement, Long> {
    RestaurantManagement findByRestaurant(Restaurant existingRestaurant);

    RestaurantManagement findByRestaurantManagementRecordId(Long restaurantManagementRecordId);
}
