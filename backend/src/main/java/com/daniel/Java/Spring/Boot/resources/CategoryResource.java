package com.daniel.Java.Spring.Boot.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.daniel.Java.Spring.Boot.dto.CategoryAllDTO;
import com.daniel.Java.Spring.Boot.dto.CategoryDTO;
import com.daniel.Java.Spring.Boot.services.CategoryService;


@RestController
@RequestMapping(value = "categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	
	@GetMapping
	private ResponseEntity<List<CategoryAllDTO>> findAll(){
		List<CategoryAllDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/page")
	private ResponseEntity<Page<CategoryAllDTO>> page(
			@RequestParam(value = "page", defaultValue="0") Integer page,
			@RequestParam(value = "linePerPage", defaultValue="5") Integer linePerPage,
			@RequestParam(value = "direction", defaultValue="ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue="id") String orderBy
			
			){
		
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);
		
		Page<CategoryAllDTO> list = service.findPage(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	private ResponseEntity<CategoryDTO> fidById(@PathVariable Long id){
		CategoryDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<CategoryAllDTO> insert(@Valid @RequestBody CategoryAllDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoryAllDTO> update(@Valid @PathVariable Long id, @RequestBody CategoryAllDTO dto){
		  dto = service.update(id, dto);
		  return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
