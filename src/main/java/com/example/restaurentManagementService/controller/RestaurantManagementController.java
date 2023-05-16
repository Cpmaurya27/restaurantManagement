package com.example.restaurentManagementService.controller;

import com.example.restaurentManagementService.model.RestaurantManagement;
import com.example.restaurentManagementService.service.RestaurantManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurantmanagement")
public class RestaurantManagementController {
    @Autowired
    private RestaurantManagementService restaurantManagementService;

    @GetMapping("/restaurantid/{restaurantid}")
    public RestaurantManagement getInformationOfRestaurantByRestaurantId(@PathVariable Long restaurantid){
        return restaurantManagementService.getInformationOfRestaurantByRestaurantEmployeeRecordId(restaurantid);
    }

    @PutMapping("/restaurantid/{restaurantEmployeeRecordId}")
    public RestaurantManagement updateInformationOfRestaurantByRestaurantId(@PathVariable Long restaurantEmployeeRecordId){
        return restaurantManagementService.updateInformationOfRestaurantByRestaurantEmployeeRecordId(restaurantEmployeeRecordId);
    }

}
