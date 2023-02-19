package com.example.Ecommerce.API.Service;


import com.example.Ecommerce.API.Model.Address;
import com.example.Ecommerce.API.Repository.AddRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddService {

    @Autowired
    AddRepository addressRepository;

    public String saveAddress(Address address){
        addressRepository.save(address);
        return "Given Address Is Saved";
    }
}