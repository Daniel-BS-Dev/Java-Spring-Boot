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

import com.daniel.Java.Spring.Boot.dto.ClientAllDTO;
import com.daniel.Java.Spring.Boot.dto.ClientDTO;
import com.daniel.Java.Spring.Boot.dto.ClientInsertDTO;
import com.daniel.Java.Spring.Boot.dto.ClientUpadateDTO;
import com.daniel.Java.Spring.Boot.entities.Address;
import com.daniel.Java.Spring.Boot.entities.City;
import com.daniel.Java.Spring.Boot.entities.Client;
import com.daniel.Java.Spring.Boot.enums.TypeClient;
import com.daniel.Java.Spring.Boot.repositories.AddressRepository;
import com.daniel.Java.Spring.Boot.repositories.CityRepository;
import com.daniel.Java.Spring.Boot.repositories.ClientRepository;
import com.daniel.Java.Spring.Boot.services.exceptions.DatabaseException;
import com.daniel.Java.Spring.Boot.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	

	@Transactional(readOnly=true)
	public Page<ClientAllDTO> findPage(PageRequest pageRequest) {
		Page<Client> page = repository.findAll(pageRequest);
		return page.map(x -> new ClientAllDTO(x));
	}
	
	@Transactional(readOnly=true)
	public List<ClientAllDTO> findAll() {
		List<Client> list = repository.findAll(Sort.by("name"));
		return list.stream().map(x -> new ClientAllDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly=true)
	public ClientDTO findById(Integer id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(()  -> new ResourceNotFoundException("Id does not exist"));
		return new ClientDTO(entity, entity.getAddress(), entity.getPhones());
	}

	@Transactional
	public ClientInsertDTO insert(ClientInsertDTO dto) {
	    Client entity = new Client();
	    insertEntity(entity, dto);
	    entity = repository.save(entity);
	    return new ClientInsertDTO(entity);
	}

	@Transactional
	public ClientUpadateDTO update(Integer id, ClientUpadateDTO dto) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(()  -> new ResourceNotFoundException("Id does not exist"));
		updateEntity(entity, dto);
		entity = repository.save(entity);
		return new ClientUpadateDTO(entity);
	}

	public void deleteById(Integer id) {
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
	
	private void updateEntity(Client entity, ClientUpadateDTO dto) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setCpfOrCnpj(dto.getCpfOrCnpj());
		entity.setType(TypeClient.toEnum(dto.getType()));
		
	}

	private void insertEntity(Client entity, ClientInsertDTO dto) {
		
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setCpfOrCnpj(dto.getCpfOrCnpj());
		entity.setType(TypeClient.toEnum(dto.getType()));
		entity.getPhones().add(dto.getPhone());
		
	    Address address = new Address();
	   
		address.setLogarant(dto.getLogarant());
		address.setNumber(dto.getNumber());
		address.setComplement(dto.getComplement());
		address.setDistrict(dto.getDistrict());
		address.setCep(dto.getCep());
		address.setClient(entity);
			
		Optional<City> obj = cityRepository.findById(dto.getCity());
		City city = obj.orElseThrow(()  -> new ResourceNotFoundException("Id does not exist"));
		address.setCity(city);
			
		address = addressRepository.save(address);
	
		entity.getAddress().add(address);
	
	}

}
