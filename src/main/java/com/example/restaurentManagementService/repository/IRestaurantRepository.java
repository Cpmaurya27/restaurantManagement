package com.example.restaurentManagementService.repository;

import com.example.restaurentManagementService.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant findByRestaurantId(Long id);
    void deleteByRestaurantId(Long id);
}
