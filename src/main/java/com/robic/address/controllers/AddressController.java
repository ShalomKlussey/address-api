package com.robic.address.controllers;

import com.robic.address.models.Address;
import com.robic.address.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress(){

       return new ResponseEntity<>(addressService.getAllAddress(), HttpStatus.OK);
    }

    @GetMapping("/order")
    public ResponseEntity<Address> getAddressByOrderNumber(@PathVariable String orderNumber){

        return addressService.getByOrderNumber(orderNumber)
                .map(address -> new ResponseEntity<>(address, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PutMapping("/id")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address updated){

        Optional<Address> addressFound = addressService.findById(id);

        if(addressFound.isPresent()){
            updated.setId(id);

            return new ResponseEntity<>(addressService.save(updated), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
