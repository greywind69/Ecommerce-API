package com.example.Ecommerce.API.Repository;

import com.example.Ecommerce.API.Model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdRepository extends JpaRepository<Product, Integer> {
}