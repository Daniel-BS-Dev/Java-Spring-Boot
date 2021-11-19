package com.daniel.Java.Spring.Boot.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.Java.Spring.Boot.dto.CategoryAllDTO;
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
	public Page<CategoryAllDTO> findPage(PageRequest pageRequest) {
		Page<Category> page = repository.findAll(pageRequest);
		return page.map(x -> new CategoryAllDTO(x));
	}
	
	@Transactional(readOnly=true)
	public List<CategoryAllDTO> findAll() {
		List<Category> list = repository.findAll(Sort.by("name"));
		return list.stream().map(x -> new CategoryAllDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly=true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(()  -> new ResourceNotFoundException("Id does not exist"));
		return new CategoryDTO(entity, entity.getProducts());
	}

	@Transactional
	public CategoryAllDTO insert(CategoryAllDTO dto) {
	    Category entity = new Category();
	    entity.setName(dto.getName());
	    entity = repository.save(entity);
		return new CategoryAllDTO(entity);
	}

	@Transactional
	public CategoryAllDTO update(Long id, CategoryAllDTO dto) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(()  -> new ResourceNotFoundException("Id does not exist"));
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CategoryAllDTO(entity);
	}

	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("id not foud "+id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Entity can not be delete beacause it is linked with product");
		}
		
	}

	

	

}
