package com.example.Ecommerce.API.Controller;

import com.example.Ecommerce.API.Model.Address;
import com.example.Ecommerce.API.Model.User;
import com.example.Ecommerce.API.Repository.UserRepository;
import com.example.Ecommerce.API.Service.AddService;
import com.example.Ecommerce.API.Repository.AddRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AddController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AddService addressService;

    @PostMapping("/addAddress")
    public ResponseEntity addAddress(@RequestBody String address){
        JSONObject jsonObject = new JSONObject(address);
        Address address1 = validateAddress(jsonObject);
        String response = addressService.saveAddress(address1);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    private Address validateAddress(JSONObject json){
        Address address = new Address();
        address.setAddressId(json.getInt("addressId"));
        address.setAddressName(json.getString("addressName"));
        address.setLandmark(json.getString("landmark"));
        address.setState(json.getString("state"));
        address.setPhoneNumber(json.getString("phoneNumber"));
        address.setZipCode(json.getString("zipCode"));
        if(json.has("userId")) {
            User user = userRepository.findById(json.getInt("userId")).get();
            address.setUser(user);
        }
        return address;
    }
}