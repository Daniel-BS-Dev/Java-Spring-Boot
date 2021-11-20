package com.daniel.Java.Spring.Boot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.Java.Spring.Boot.dto.ProductDTO;
import com.daniel.Java.Spring.Boot.entities.Product;
import com.daniel.Java.Spring.Boot.resources.utils.Url;
import com.daniel.Java.Spring.Boot.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	
	@GetMapping
	private ResponseEntity<Page<ProductDTO>> findAll(
			@RequestParam(value = "name", defaultValue="a") String name,
			@RequestParam(value = "categories", defaultValue="1") String categories,
			@RequestParam(value = "page", defaultValue="0") Integer page,
			@RequestParam(value = "linePerPage", defaultValue="5") Integer linePerPage,
			@RequestParam(value = "direction", defaultValue="ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue="id") String orderBy
			
			){
		
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);
		
		//chamando minha função da url
		List<Long> ids = Url.decodeIntList(categories);
		
		//chamando minha função
		String nameDecoded = Url.decodeParam(name);
		
		Page<Product> list = service.search(nameDecoded, ids, pageRequest);
		Page<ProductDTO> listDto = list.map(x -> new ProductDTO(x));
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/{id}")
	private ResponseEntity<ProductDTO> fidById(@PathVariable Long id){
		ProductDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

}
