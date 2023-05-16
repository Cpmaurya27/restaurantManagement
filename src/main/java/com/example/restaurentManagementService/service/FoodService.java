package com.example.restaurentManagementService.service;

import com.example.restaurentManagementService.model.Food;
import com.example.restaurentManagementService.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    IFoodRepository iFoodRepository;

    public List<Food> showFood() {
        return iFoodRepository.findAll();
    }
}
