package br.com.baratellagabriel.correios.service;

import org.springframework.stereotype.Service;

import br.com.baratellagabriel.correios.model.Address;
import br.com.baratellagabriel.correios.model.Status;

@Service
public class CorreiosService {
	
	public Status getStatus() {
		return Status.READY;
	}
	
	public Address getAddressByZipCode(String zipcode) {
		return null;
	}
	
	public void setup(){
		
	}
}
