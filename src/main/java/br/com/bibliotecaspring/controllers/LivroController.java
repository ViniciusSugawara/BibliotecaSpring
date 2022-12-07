package br.com.bibliotecaspring.controllers;

import br.com.bibliotecaspring.repositorios.LivroRepositorio;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {
    private LivroRepositorio livroRepositorio;

    public LivroController(LivroRepositorio livroRepositorio){
        this.livroRepositorio = livroRepositorio;
    }
}
