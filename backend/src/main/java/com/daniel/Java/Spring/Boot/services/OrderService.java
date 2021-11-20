package com.daniel.Java.Spring.Boot.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.Java.Spring.Boot.dto.OrderDTO;
import com.daniel.Java.Spring.Boot.entities.Order;
import com.daniel.Java.Spring.Boot.repositories.OrderRepository;
import com.daniel.Java.Spring.Boot.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly=true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findAll(Sort.by("id"));
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly=true)
	public OrderDTO findById(Integer id) {
		Optional<Order> obj = repository.findById(id);
		Order entity = obj.orElseThrow(()  -> new ResourceNotFoundException("Id does not exist"));
		return new OrderDTO(entity, entity.getItemOrder());
	}

	

}
