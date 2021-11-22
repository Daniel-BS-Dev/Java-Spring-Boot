package com.daniel.Java.Spring.Boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.Java.Spring.Boot.entities.ItemOrder;
import com.daniel.Java.Spring.Boot.entities.pk.ItemOrderPk;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder, ItemOrderPk> {

}
