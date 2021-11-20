package com.daniel.Java.Spring.Boot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.Java.Spring.Boot.dto.ProductDTO;
import com.daniel.Java.Spring.Boot.entities.Category;
import com.daniel.Java.Spring.Boot.entities.Product;
import com.daniel.Java.Spring.Boot.repositories.CategoryRepository;
import com.daniel.Java.Spring.Boot.repositories.ProductRepository;
import com.daniel.Java.Spring.Boot.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional(readOnly=true)
	public Page<Product> search(String name, List<Long> ids, PageRequest page) {
		List<Category> categories = categoryRepository.findAllById(ids);
		return repository.findDistinctByNomeContainingAndCategoriasIn(name, categories, page);
	}

	@Transactional(readOnly=true)
	public ProductDTO findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		Product entity = obj.orElseThrow(()  -> new ResourceNotFoundException("Id does not exist"));
		return new ProductDTO(entity);
	}

	

}
