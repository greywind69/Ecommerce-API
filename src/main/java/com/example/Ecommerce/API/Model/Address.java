package com.example.Ecommerce.API.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "address-table")

public class Address {
    @Id
    @Column(name = "address_id")
    private Integer addressId;
    @Column(name = "address_name")
    private String addressName;
    @Column(name = "landmark")
    private String landmark;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "state")
    private String state;
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Address(Integer addressId){
        this.addressId = addressId;
    }
}