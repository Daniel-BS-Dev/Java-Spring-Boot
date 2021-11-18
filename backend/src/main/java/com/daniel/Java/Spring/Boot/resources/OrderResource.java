package com.daniel.Java.Spring.Boot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.Java.Spring.Boot.dto.OrderDTO;
import com.daniel.Java.Spring.Boot.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	
	@GetMapping
	private ResponseEntity<List<OrderDTO>> findAll(){
		List<OrderDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	private ResponseEntity<OrderDTO> fidById(@PathVariable Integer id){
		OrderDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

}
