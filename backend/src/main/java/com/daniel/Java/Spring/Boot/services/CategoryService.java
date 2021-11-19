package com.daniel.Java.Spring.Boot.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.Java.Spring.Boot.dto.CategoryDTO;
import com.daniel.Java.Spring.Boot.dto.ProductDTO;
import com.daniel.Java.Spring.Boot.entities.Category;
import com.daniel.Java.Spring.Boot.entities.Product;
import com.daniel.Java.Spring.Boot.repositories.CategoryRepository;
import com.daniel.Java.Spring.Boot.repositories.ProductRepository;
import com.daniel.Java.Spring.Boot.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private ProductRepository product;
	
	@Transactional(readOnly=true)
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll(Sort.by("name"));
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly=true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(()  -> new ResourceNotFoundException("Id does not exist"));
		return new CategoryDTO(entity, entity.getProducts());
	}

	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
	    Category entity = new Category();
	    entity.setName(dto.getName());
	    entity = repository.save(entity);
		return new CategoryDTO(entity);
	}

	

}
