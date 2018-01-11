package com.personservice.poc.model.model;

public class PersonModel {

    private int personId;
    private int addressId;
    private String name;
    private int age;

    public PersonModel(int personId, int addressId, String name, int age) {
        this.personId = personId;
        this.addressId = addressId;
        this.name = name;
        this.age = age;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "personId=" + personId +
                ", addressId=" + addressId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
