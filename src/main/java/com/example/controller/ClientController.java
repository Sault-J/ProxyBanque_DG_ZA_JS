package com.example.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ClientDTO;

import com.example.service.ClientService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/clients")
public class ClientController {
	
	private ClientService clientService;
	
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
		
	}

	
	@GetMapping()
	Iterable<ClientDTO> getClients() {
		return clientService.getAllClients();
	}
	
	@GetMapping("/{id}")
	Optional<ClientDTO> getClientById(@PathVariable Long id) {
		return clientService.getClientById(id);
	}

	@PostMapping()
	ResponseEntity<ClientDTO> postClient(@Valid @RequestBody ClientDTO client) {
		
		return clientService.saveClient(client);
	}
	
	

	@DeleteMapping("/{id}")
	void deleteClient(@PathVariable Long id) {
		clientService.deleteClientById(id);
	}

//	@PutMapping("/{id}")
//	ResponseEntity<Client> putClient(@PathVariable Long id, @RequestBody ClientDTO client){
//			
//			return (clientService.isClientIdExists(id)) ? 
//					new ResponseEntity<>(clientService.saveClient(client), HttpStatus.OK) :
//					new ResponseEntity<>(clientService.saveClient(client), HttpStatus.CREATED);
//	}
	
	///////////////////////////////////////////Exceptions
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String,String> handleValidationException(MethodArgumentNotValidException ex){
		HashMap<String,String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(
				e -> {
					String fieldName = ((FieldError) e).getField();
					String errorMsg = e.getDefaultMessage();
					
					errors.put(fieldName, errorMsg);
					
				});
		return errors;
	}


	public ClientService getClientService() {
		return clientService;
	}


	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	
		
					

	
}
