package br.com.baratellagabriel.correios.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AddressStatus {
	
	@Id
	private int id;
	private Status status;

}
