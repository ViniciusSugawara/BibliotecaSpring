package br.com.controllers;

import br.com.repositorios.AutorRepositorio;
import org.springframework.stereotype.Controller;

@Controller
public class AutorController {
    private AutorRepositorio autorRepositorio;

    public AutorController(AutorRepositorio autorRepositorio){
        this.autorRepositorio = autorRepositorio;
    }
}
