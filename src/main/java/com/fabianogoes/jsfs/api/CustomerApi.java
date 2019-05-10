package com.fabianogoes.jsfs.api;

import com.fabianogoes.jsfs.exception.ResourceNotFoundException;
import com.fabianogoes.jsfs.model.Customer;
import com.fabianogoes.jsfs.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerApi implements CrudApi<Customer> {

    CustomerService service;

    @Autowired
    public CustomerApi(CustomerService service) {
        this.service = service;
    }


    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Customer> post(@RequestBody Customer resource) {
        Customer customer = service.create(resource);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<Customer> get(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping
    public ResponseEntity<Iterable<Customer>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public ResponseEntity<Customer> put(@RequestBody Customer resource, @PathVariable String id) {
        return new ResponseEntity<>(service.update(id, resource), HttpStatus.ACCEPTED);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
