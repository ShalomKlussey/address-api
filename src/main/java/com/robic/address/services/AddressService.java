package com.robic.address.services;

import com.robic.address.models.Address;
import com.robic.address.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Optional<Address> findById(Long id){

        return addressRepository.findById(id);
    }
    public Address save(Address address){
        return addressRepository.save(address);
    }
    public List<Address> getAllAddress(){

        return addressRepository.findAll();
    }

    public Optional<Address> getByOrderNumber(String orderNumber){
        return addressRepository.findByOrderNumber(orderNumber);
    }
}
