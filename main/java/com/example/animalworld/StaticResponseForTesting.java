package com.example.animalworld;

public class StaticResponseForTesting
{

    private String PetName;
    private String PetAge;

    public StaticResponseForTesting(String petName, String petAge) {
        PetName = petName;
        PetAge = petAge;
    }

    public String getPetName() {
        return PetName;
    }

    public void setPetName(String petName) {
        PetName = petName;
    }

    public String getPetAge() {
        return PetAge;
    }

    public void setPetAge(String petAge) {
        PetAge = petAge;
    }


}
