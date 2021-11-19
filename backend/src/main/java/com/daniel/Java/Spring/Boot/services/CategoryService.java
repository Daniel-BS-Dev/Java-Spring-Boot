package com.daniel.Java.Spring.Boot.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.Java.Spring.Boot.dto.CategoryDTO;
import com.daniel.Java.Spring.Boot.entities.Category;
import com.daniel.Java.Spring.Boot.repositories.CategoryRepository;
import com.daniel.Java.Spring.Boot.services.exceptions.DatabaseException;
import com.daniel.Java.Spring.Boot.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
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

	public CategoryDTO update(Long id, CategoryDTO dto) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(()  -> new ResourceNotFoundException("Id does not exist"));
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CategoryDTO(entity);
	}

	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("id not foud "+id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
		
	}

	

}
