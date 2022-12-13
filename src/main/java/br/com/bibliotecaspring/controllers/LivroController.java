package br.com.bibliotecaspring.controllers;

import br.com.bibliotecaspring.models.Livro;
import br.com.bibliotecaspring.servicos.LivroServico;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivroController {
    private LivroServico livroServico;

    public LivroController(LivroServico livroServico){
        this.livroServico = livroServico;
    }

    @RequestMapping("/index")
    @GetMapping
    public List<Livro> findAll(){
        return livroServico.findAll();
    }

    @RequestMapping({"/findById"})
    @GetMapping
    public Livro findById(Long id){
        return livroServico.findById(id);
    }

    @RequestMapping("/returnMock")
    @GetMapping
    public Livro retornaLivro(){
        Livro LivroMock = new Livro();
        LivroMock.setNome("AErfj9-0wossfkweo0");
        return LivroMock;
    }

    @RequestMapping("/store")
    @PostMapping
    public void save(Livro object){
        this.livroServico.save(object);
    }
    @RequestMapping("/delete")
    @DeleteMapping
    public void delete(Livro object){
        this.livroServico.delete(object);
    }

    @RequestMapping("/deleteById")
    @DeleteMapping
    public void deleteById(Long id){
        this.livroServico.deleteById(id);
    }
}
