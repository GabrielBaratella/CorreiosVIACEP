package br.com.baratellagabriel.correios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.baratellagabriel.correios.exception.NoContentException;
import br.com.baratellagabriel.correios.exception.NotReadyException;
import br.com.baratellagabriel.correios.model.Address;
import br.com.baratellagabriel.correios.model.AddressStatus;
import br.com.baratellagabriel.correios.model.Status;
import br.com.baratellagabriel.correios.repository.AddressRepository;
import br.com.baratellagabriel.correios.repository.AddressStatusRepository;
import br.com.baratellagabriel.correios.repository.SetupRepository;

@Service
public class CorreiosService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressStatusRepository addressStatusRepository;
	
	@Autowired
	private SetupRepository setupRepository;
	
	public Status getStatus() {
		return addressStatusRepository.findById(AddressStatus.DEFAULT_ID)
				.orElse(AddressStatus.builder().status(Status.NEED_SETUP).build()).getStatus();
	}
	
	public Address getAddressByZipCode(String zipcode) throws NoContentException, NotReadyException {
		
		if(!this.getStatus().equals(Status.READY)) {
			throw new NotReadyException();
		}
		
		return addressRepository.findById(zipcode).orElseThrow(NoContentException::new);
	}
	
	private void saveStatus(Status status) {
		this.addressStatusRepository.save(AddressStatus.builder().id(AddressStatus.DEFAULT_ID).status(status)
		.build());
	}
	
	protected void setupOnStartup() {
		try {
			this.setup();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setup() throws Exception{
		
		if(this.getStatus().equals(Status.NEED_SETUP)) {
			this.saveStatus(Status.SETUP_RUNNING);
			
			try {
				this.addressRepository.saveAll(this.setupRepository.getFromOrigin());
			}catch(Exception exc) {
				this.saveStatus(Status.NEED_SETUP);
				throw exc;
			}
			
			this.saveStatus(Status.READY);
		}
		
		
	}
}
