package br.com.baratellagabriel.correios.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.baratellagabriel.correios.model.Address;

public interface AddressRepository extends CrudRepository<Address, String> {

}
