package com.daniel.Java.Spring.Boot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.Java.Spring.Boot.dto.ClientDTO;
import com.daniel.Java.Spring.Boot.services.ClientService;

@RestController
@RequestMapping(value = "clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	
	@GetMapping
	private ResponseEntity<List<ClientDTO>> findAll(){
		List<ClientDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	private ResponseEntity<ClientDTO> fidById(@PathVariable Integer id){
		ClientDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

}
