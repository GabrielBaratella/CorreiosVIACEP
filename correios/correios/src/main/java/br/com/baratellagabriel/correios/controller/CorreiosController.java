package br.com.baratellagabriel.correios.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.baratellagabriel.correios.exception.NoContentException;
import br.com.baratellagabriel.correios.exception.NotReadyException;
import br.com.baratellagabriel.correios.model.Address;
import br.com.baratellagabriel.correios.service.CorreiosService;

@RestController
public class CorreiosController {
	
	@Autowired
	private CorreiosService service;

	@GetMapping("/status")
	public String getStatus() {
		return "Server Status" + service.getStatus();
	}
	
	@GetMapping("/zipcode/{zipcode}")
	public Address getAdressByZipCode(@PathVariable("zipcode")String zipcode) throws NoContentException, NotReadyException {
		return this.service.getAddressByZipCode(zipcode);
	}
}
