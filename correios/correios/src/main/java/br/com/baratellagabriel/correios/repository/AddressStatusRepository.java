package br.com.baratellagabriel.correios.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.baratellagabriel.correios.model.AddressStatus;

public interface AddressStatusRepository extends CrudRepository<AddressStatus, String> {

}
