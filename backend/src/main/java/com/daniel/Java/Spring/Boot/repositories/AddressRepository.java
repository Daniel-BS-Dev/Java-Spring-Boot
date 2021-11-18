package com.daniel.Java.Spring.Boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.Java.Spring.Boot.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
