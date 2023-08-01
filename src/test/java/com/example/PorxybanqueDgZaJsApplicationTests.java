package com.example;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.controller.ClientController;
import com.example.dto.ClientDTO;
import com.example.entities.Client;
import com.example.service.ClientServiceImpl;

@SpringBootTest
class PorxybanqueDgZaJsApplicationTests {

///Controller
	@Autowired
	private ClientController client;
	
	@Test
	void clientControllerShouldBeNotNull() {
		assertNotNull(client);
	}
	
	@Test
	void clientServiceShouldBeNotNull() {
		assertNotNull(client.getClientService());
	}
	
	
///Service	
	@Autowired
	private ClientServiceImpl service;

	@Test
	void clientDAOShouldBeNotNull() {
		assertNotNull(service.getClientDAO());
	}
	
	@Test
	void conseillerDAOShouldBeNotNull() {
		assertNotNull(service.getConseillerDAO());
	}
	
	@Test
	void getClientByIdShouldReturnAClientDTO() {
		
		assertInstanceOf(ClientDTO.class, service.getClientById(1L).get());
	}
	
	@Test
	void getAllClientsShouldReturnAListOfClientDTO() {
		
		List<ClientDTO> a = new ArrayList<ClientDTO>();
		assertInstanceOf(a.getClass(), service.getAllClients());
	}
	
	@Test
	void getAllClientsShouldReturnAListOfClientDTO2() {
		
		List<Client> a = new ArrayList<Client>();
		assertNotSame(a.getClass(), service.getAllClients());
	}
	
	
	
	
	
	
}
