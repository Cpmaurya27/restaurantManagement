package com.example.restaurentManagementService.repository;

import com.example.restaurentManagementService.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodRepository extends JpaRepository<Food, Long> {
}
