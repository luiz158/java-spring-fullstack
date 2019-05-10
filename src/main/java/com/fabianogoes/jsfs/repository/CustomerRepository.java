package com.fabianogoes.jsfs.repository;

import com.fabianogoes.jsfs.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
}
