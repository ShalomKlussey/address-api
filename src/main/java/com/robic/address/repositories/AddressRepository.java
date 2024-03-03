package com.robic.address.repositories;

import com.robic.address.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("select a from Address a where a.orderNumber = ?1")
    Optional<Address> findByOrderNumber(String orderNumber);


}
