package com.example.animalworld;

import java.util.ArrayList;
import java.util.List;

public class PetResponse
{
    /**
     * id : 1
     * createdAt : 2021-06-21T11:39:03.670Z
     * name : French Bulldog
     * avatar : http://placeimg.com/640/480/animals
     * bornAt : 2021-01-28T04:26:47.647Z
     * Id : 78912
     * Customer : Jason Sweet
     * Quantity : 1
     * Price : 18
     */

    private String id;
    private String createdAt;
    private String name;
    private String avatar;
    private String bornAt;
    private int Id;
    private String Customer;
    private int Quantity;
    private int Price;

    public String getId2() {
        return id;
    }

    public void setId2(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBornAt() {
        return bornAt;
    }

    public void setBornAt(String bornAt) {
        this.bornAt = bornAt;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String Customer) {
        this.Customer = Customer;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }





}
