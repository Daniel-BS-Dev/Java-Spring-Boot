package com.daniel.Java.Spring.Boot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.Java.Spring.Boot.dto.CategoryDTO;
import com.daniel.Java.Spring.Boot.services.CategoryService;

@RestController
@RequestMapping(value = "categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping(value="/{id}")
	private ResponseEntity<CategoryDTO> fidById(@PathVariable Integer id){
		CategoryDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

}
