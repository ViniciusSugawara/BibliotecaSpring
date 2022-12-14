package br.com.bibliotecaspring.controllers;

import br.com.bibliotecaspring.dto.LivroDTO;
import br.com.bibliotecaspring.models.Livro;
import br.com.bibliotecaspring.servicos.LivroServico;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {
    private LivroServico livroServico;

    public LivroController(LivroServico livroServico){
        this.livroServico = livroServico;
    }

    @RequestMapping("/index")
    @GetMapping
    public List<LivroDTO> findAll(){
        return livroServico.findAll();
    }

    @RequestMapping({"/index/{id}"})
    @GetMapping
    public LivroDTO findById(@PathVariable("id") Long id){
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
    public void save(@RequestBody Livro object){
        this.livroServico.save(object);
    }
    @RequestMapping("/delete")
    @DeleteMapping
    public void delete(@RequestBody Livro object){
        this.livroServico.delete(object);
    }

    @RequestMapping("/delete/{id}")
    @DeleteMapping
    public void deleteById(@PathVariable("id") Long id){
        this.livroServico.deleteById(id);
    }
}
