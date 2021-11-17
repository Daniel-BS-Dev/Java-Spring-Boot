package com.daniel.Java.Spring.Boot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.Java.Spring.Boot.dto.CategoryDTO;
import com.daniel.Java.Spring.Boot.entities.Category;
import com.daniel.Java.Spring.Boot.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;

	@Transactional(readOnly=true)
	public CategoryDTO findById(Integer id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.get();
		return new CategoryDTO(entity);
	}

}
