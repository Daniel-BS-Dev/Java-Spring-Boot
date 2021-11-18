package com.daniel.Java.Spring.Boot.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.Java.Spring.Boot.dto.ClientDTO;
import com.daniel.Java.Spring.Boot.entities.Client;
import com.daniel.Java.Spring.Boot.repositories.ClientRepository;
import com.daniel.Java.Spring.Boot.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly=true)
	public List<ClientDTO> findAll() {
		List<Client> list = repository.findAll(Sort.by("name"));
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly=true)
	public ClientDTO findById(Integer id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(()  -> new ResourceNotFoundException("Id does not exist"));
		return new ClientDTO(entity, entity.getAddress(), entity.getPhones());
	}

	

}
