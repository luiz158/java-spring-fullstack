package com.fabianogoes.jsfs.service.impl;

import com.fabianogoes.jsfs.exception.ResourceNotFoundException;
import com.fabianogoes.jsfs.model.Customer;
import com.fabianogoes.jsfs.repository.CustomerRepository;
import com.fabianogoes.jsfs.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer create(Customer entity) {
        return repository.save(entity);
    }

    @Override
    public Iterable<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer getById(String id){
        Optional<Customer> optional = repository.findById(id);
        if(!optional.isPresent()) {
            throw new ResourceNotFoundException(id);
        }
        return optional.get();
    }

    @Override
    public Customer update(String id, Customer entity) {
        Optional<Customer> optional = repository.findById(id);
        if(!optional.isPresent()) {
            throw new ResourceNotFoundException(id);
        }
        return repository.save(entity);
    }

    @Override
    public void delete(String id) {
        Optional<Customer> optional = repository.findById(id);
        if(!optional.isPresent()) {
            throw new ResourceNotFoundException(id);
        }
        repository.delete(optional.get());
    }

}
