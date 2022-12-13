package br.com.bibliotecaspring.controllers;

import br.com.bibliotecaspring.repositorios.LivroRepositorio;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {
    private LivroServico livroServico;

    public LivroController(LivroServico livroServico){
        this.livroServico = livroServico;
    }

    public LivroController(LivroRepositorio livroRepositorio){
        this.livroRepositorio = livroRepositorio;
    }
}
