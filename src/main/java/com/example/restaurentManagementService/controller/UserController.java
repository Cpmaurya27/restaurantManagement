package com.example.restaurentManagementService.controller;

import com.example.restaurentManagementService.dto.SignInInput;
import com.example.restaurentManagementService.dto.SignInOutput;
import com.example.restaurentManagementService.dto.SignUpInput;
import com.example.restaurentManagementService.dto.SignUpOutput;
import com.example.restaurentManagementService.model.Food;
import com.example.restaurentManagementService.service.AuthenticationService;
import com.example.restaurentManagementService.service.FoodService;
import com.example.restaurentManagementService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private FoodService foodService;

    //signup->signUp input -> signUp output

    @PostMapping("/signup")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpInput) {
        return userService.signUp(signUpInput);
    }

    @PostMapping("/signin")
    public SignInOutput signUp(@RequestBody SignInInput signInInput){
        return userService.signIn(signInInput);
    }

    @GetMapping("/food")
    public ResponseEntity<List<Food>> getAllFoods(@RequestParam String userEmail, @RequestParam String token){
        HttpStatus status;
        List<Food> foodList = null;
        //authenticate

        if(authenticationService.authenticate(userEmail,token)){
            foodList = foodService.showFood();
            status = HttpStatus.FOUND;
        }else{
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<List<Food>>(foodList,status);
    }


}
