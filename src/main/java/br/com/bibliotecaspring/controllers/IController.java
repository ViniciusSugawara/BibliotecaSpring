package br.com.bibliotecaspring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IController<T_input, T_output>{

    ResponseEntity<List<T_output>> findAll();
    ResponseEntity<T_output> findById(Long id);
    ResponseEntity<T_input> save(@RequestBody T_input object);
    ResponseEntity<T_input> update(@RequestBody T_input object);
    ResponseEntity delete(@RequestBody T_input object);
    ResponseEntity deleteById(@PathVariable("id") Long id);
}
