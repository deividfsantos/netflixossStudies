package com.addressservice.poc.dao;

import com.addressservice.poc.model.AddressModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressDAO {

    private List<AddressModel> addressModels = new ArrayList<>();

    public AddressDAO() {
        addressModels.add(new AddressModel(1,"Rua abc", "Gravataí"));
        addressModels.add(new AddressModel(2,"Rua def", "Porto Alegre"));
        addressModels.add(new AddressModel(3,"Rua ghi", "Canoas"));
        addressModels.add(new AddressModel(4,"Rua jkl", "Cachoerinha"));

    }

    public List<AddressModel> getAddressModels() {
        return addressModels;
    }

    public void setAddressModels(List<AddressModel> addressModels) {
        this.addressModels = addressModels;
    }

    public AddressModel getAddressById(int addressId) {
        return addressModels.get(addressId-1);
    }
}
