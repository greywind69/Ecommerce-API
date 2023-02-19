package com.example.Ecommerce.API.Controller;

import com.example.Ecommerce.API.Model.Product;
import com.example.Ecommerce.API.Service.ProdService;
import com.example.Ecommerce.API.Model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProdController {
    @Autowired
    ProdService productService;

    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@RequestBody String product){
        JSONObject jsonObject = new JSONObject(product);
        Product product1 = validateUser(jsonObject);
        String response = productService.saveProduct(product1);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    private Product validateUser(JSONObject json){
        Product product = new Product();
        product.setProductId(json.getInt("productId"));
        product.setProductName(json.getString("productName"));
        product.setPrice(json.getInt("price"));
        product.setDescription(json.getString("description"));
        product.setCategory(json.getString("category"));
        product.setBrand(json.getString("brand"));
        return product;
    }

    @GetMapping("/getProducts")
    public List<Product> getProduct(){
        return productService.get();
    }
    @GetMapping("/getProduct")
    public Product get(@RequestParam String category){
        return productService.getByCategory(category);
    }
    @DeleteMapping("/deleteProduct/productId")
    public ResponseEntity deleteProduct(@PathVariable Integer productId){
        String response = productService.delete(productId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}