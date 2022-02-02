package com.example.animalworld;

public class SortingResponse
{
    /**
     * id : 2
     * createdAt : 2021-06-20T18:28:43.622Z
     * name : Sardinian Shepherd Dog
     * avatar : http://placeimg.com/640/480/animals
     * bornAt : 2020-08-30T09:08:48.246Z
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

    public String getid() {
        return id;
    }

    public void setid(String id) {
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
