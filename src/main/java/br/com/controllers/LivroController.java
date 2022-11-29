package br.com.controllers;

import br.com.repositorios.LivroRepositorio;
import org.springframework.stereotype.Controller;

@Controller
public class LivroController {
    private LivroRepositorio livroRepositorio;

    public LivroController(LivroRepositorio livroRepositorio){
        this.livroRepositorio = livroRepositorio;
    }
}
