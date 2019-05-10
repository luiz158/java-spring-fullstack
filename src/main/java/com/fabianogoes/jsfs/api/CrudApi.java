package com.fabianogoes.jsfs.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface CrudApi<T> {

    ResponseEntity<T> post(@RequestBody T resource);
    ResponseEntity<T> get(@PathVariable String id);
    ResponseEntity<Iterable<T>> getAll();
    ResponseEntity<T> put(@RequestBody T resource, @PathVariable String id);
    ResponseEntity<T> delete(@PathVariable String id);

}
