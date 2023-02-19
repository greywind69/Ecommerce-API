package com.example.Ecommerce.API.Service;

import com.example.Ecommerce.API.Repository.ProdRepository;

import com.example.Ecommerce.API.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdService {
    @Autowired
    ProdRepository productRepository;

    public String saveProduct(Product product){
        productRepository.save(product);
        return "Given Product is Saved";
    }

    public List<Product> get() {
        return productRepository.findAll();
    }

    public String delete(Integer productId) {
        productRepository.deleteById(productId);
        return "Product is Deleted";
    }

    public Product getByCategory(String category) {
        List<Product> products = productRepository.findAll();
        Product newproduct = null;
        for(Product product : products){
            if(product.getCategory().equals(category)){
                newproduct = product;
            }
        }
        return newproduct;
    }
}