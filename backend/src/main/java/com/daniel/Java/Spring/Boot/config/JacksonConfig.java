package com.daniel.Java.Spring.Boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.daniel.Java.Spring.Boot.entities.PaymentWithBankSlip;
import com.daniel.Java.Spring.Boot.entities.PaymentWithCard;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonConfig {
	
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(PaymentWithBankSlip.class);
				objectMapper.registerSubtypes(PaymentWithCard.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}

}
