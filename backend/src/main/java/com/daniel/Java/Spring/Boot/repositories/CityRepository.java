package com.daniel.Java.Spring.Boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.Java.Spring.Boot.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
