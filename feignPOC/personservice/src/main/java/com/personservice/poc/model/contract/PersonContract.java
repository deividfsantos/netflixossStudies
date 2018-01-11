package com.personservice.poc.model.contract;

import com.personservice.poc.model.model.AddressModel;

public class PersonContract {

    private AddressModel addressModel;
    private String name;
    private int age;

    public PersonContract(AddressModel addressModel, String name, int age) {
        this.addressModel = addressModel;
        this.name = name;
        this.age = age;
    }

    public AddressModel getAddressModel() {
        return addressModel;
    }

    public void setAddressModel(AddressModel addressModel) {
        this.addressModel = addressModel;
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
        return "PersonContract{" +
                "addressModel=" + addressModel +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
