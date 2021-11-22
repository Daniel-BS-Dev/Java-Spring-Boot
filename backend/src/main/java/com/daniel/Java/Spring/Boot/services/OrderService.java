package com.daniel.Java.Spring.Boot.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.Java.Spring.Boot.dto.OrderDTO;
import com.daniel.Java.Spring.Boot.entities.ItemOrder;
import com.daniel.Java.Spring.Boot.entities.Order;
import com.daniel.Java.Spring.Boot.entities.PaymentWithBankSlip;
import com.daniel.Java.Spring.Boot.entities.Product;
import com.daniel.Java.Spring.Boot.enums.StatePayment;
import com.daniel.Java.Spring.Boot.repositories.ItemOrderRepository;
import com.daniel.Java.Spring.Boot.repositories.OrderRepository;
import com.daniel.Java.Spring.Boot.repositories.PaymentRepository;
import com.daniel.Java.Spring.Boot.repositories.ProductRepository;
import com.daniel.Java.Spring.Boot.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ItemOrderRepository itemOrderRepository;
	
	
	@Transactional(readOnly=true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findAll(Sort.by("id"));
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly=true)
	public OrderDTO findById(Integer id) {
		Optional<Order> obj = repository.findById(id);
		Order entity = obj.orElseThrow(()  -> new ResourceNotFoundException("Id does not exist"));
		return new OrderDTO(entity, entity.getItemOrder());
	}

	public  Order insert(@Valid Order entity) {
		entity.setId(null);
		entity.setDate(Instant.now());
		entity.getPayment().setState(StatePayment.PENDING);
		entity.getPayment().setOrders(entity);
		if(entity.getPayment() instanceof PaymentWithBankSlip) {
			PaymentWithBankSlip paid = (PaymentWithBankSlip) entity.getPayment();
		    fillOut(paid, entity.getDate());
		}
		
		entity = repository.save(entity);
		paymentRepository.save(entity.getPayment());
		
		
		for(ItemOrder o : entity.getItemOrder()){
			o.setDiscount(0.0);
			//Optional<Product> obj = productRepository.findById(o.getProduct().getId());
			Product prod = productRepository.getById(o.getProduct().getId());
			o.setPrice(prod.getPrice());
			o.setOrder(entity);
		}
		
		itemOrderRepository.saveAll(entity.getItemOrder());
		
		return entity;
	}

	private void fillOut(PaymentWithBankSlip paid, Instant instantPayment) {
		instantPayment = instantPayment.plusNanos(7);
		paid.setPayDate(instantPayment);
		
	}

}
