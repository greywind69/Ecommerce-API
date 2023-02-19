package com.example.Ecommerce.API.Controller;

import com.example.Ecommerce.API.Service.UserService;
import com.example.Ecommerce.API.Model.Order;
import com.example.Ecommerce.API.Model.User;
;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/addUser")
    public ResponseEntity saveUser(@RequestBody String user){
        JSONObject jsonObject = new JSONObject(user);
        User newUser = validateUser(jsonObject);
        String response = userService.addUser(newUser);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    private User validateUser(JSONObject json){
        User newUser = new User();
        newUser.setUserId(json.getInt("userId"));
        newUser.setName(json.getString("name"));
        newUser.setEmail(json.getString("email"));
        newUser.setPassword(json.getString("password"));
        newUser.setPhoneNumber(json.getString("phoneNumber"));
        return newUser;
    }
    @GetMapping("/getUser/{userId}")
    public User getUser(@PathVariable Integer userId){
        return userService.get(userId);
    }

}