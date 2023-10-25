package com.example.onlinemarketplace.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    private long id;

    private String title;

    private String description;

    private int price;

    private String city;

    private User author;


}
