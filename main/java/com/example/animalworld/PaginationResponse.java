package com.example.animalworld;

public class PaginationResponse
{
    /**
     * id : 1
     * createdAt : 2021-06-21T11:39:03.670Z
     * name : French Bulldog
     * avatar : http://placeimg.com/640/480/animals
     * bornAt : 2021-01-28T04:26:47.647Z
     */

    private String id;
    private String createdAt;
    private String name;
    private String avatar;
    private String bornAt;


    public PaginationResponse(String name,String bornAt) {
        this.name = name;
        this.bornAt = bornAt;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
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

}
