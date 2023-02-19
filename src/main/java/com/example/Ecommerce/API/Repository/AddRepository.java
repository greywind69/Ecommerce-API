package com.example.Ecommerce.API.Repository;
import com.example.Ecommerce.API.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddRepository extends JpaRepository<Address, Integer> {
}



