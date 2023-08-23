package br.com.baratellagabriel.correios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.baratellagabriel.correios.exception.NoContentException;
import br.com.baratellagabriel.correios.model.Address;
import br.com.baratellagabriel.correios.model.Status;
import br.com.baratellagabriel.correios.repository.AddressRepository;
import br.com.baratellagabriel.correios.repository.AddressStatusRepository;

@Service
public class CorreiosService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressStatusRepository addressStatusRepository;
	
	public Status getStatus() {
		return Status.READY;
	}
	
	public Address getAddressByZipCode(String zipcode) throws NoContentException {
		
		return addressRepository.findById(zipcode).orElseThrow(NoContentException::new);
	}
	
	public void setup(){
		
	}
}
