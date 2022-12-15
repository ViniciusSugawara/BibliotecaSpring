package br.com.bibliotecaspring.controllers;

import br.com.bibliotecaspring.dto.LivroDTO;
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

    @GetMapping("/livros")
    public List<LivroDTO> findAll(){
        return livroServico.findAll();
    }

    @GetMapping("/livro/{id}")
    public LivroDTO findById(@PathVariable("id") Long id){
        return livroServico.findById(id);
    }

    @GetMapping("/livro/returnMock")
    public Livro retornaLivro(){
        Livro LivroMock = new Livro();
        LivroMock.setNome("AErfj9-0wossfkweo0");
        return LivroMock;
    }

    @PostMapping("/livro")
    public void save(@RequestBody Livro object){
        this.livroServico.save(object);
    }
    @PutMapping("/livro")
    public void update(@RequestBody LivroDTO object){
        this.livroServico.update(object);
    }

    @DeleteMapping("/livro")
    public void delete(@RequestBody Livro object){
        this.livroServico.delete(object);
    }

    @DeleteMapping("/livro/{id}")
    public void deleteById(@PathVariable("id") Long id){
        this.livroServico.deleteById(id);
    }
}
