package br.com.bibliotecaspring.controllers;

import br.com.bibliotecaspring.dto.LivroDTO;
import br.com.bibliotecaspring.models.Livro;
import br.com.bibliotecaspring.servicos.LivroServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivroController {
    private LivroServico livroServico;

    public LivroController(LivroServico livroServico){
        this.livroServico = livroServico;
    }

    @GetMapping("/livros")
    public ResponseEntity<List<LivroDTO>> findAll(){
        return new ResponseEntity<>(livroServico.findAll(), HttpStatus.OK);
    }

    @GetMapping("/livro/{id}")
    public ResponseEntity<LivroDTO> findById(@PathVariable("id") Long id){
        return new ResponseEntity(livroServico.findById(id), HttpStatus.OK);
    }

    @GetMapping("/livro/returnMock")
    public Livro retornaLivro(){
        Livro LivroMock = new Livro();
        LivroMock.setNome("AErfj9-0wossfkweo0");
        return LivroMock;
    }

    @PostMapping("/livro")
    public ResponseEntity<LivroDTO> save(@RequestBody LivroDTO object){
        this.livroServico.save(object);
        return new ResponseEntity<>(object, HttpStatus.CREATED);
    }
    @PutMapping("/livro")
    public ResponseEntity<LivroDTO> update(@RequestBody LivroDTO object){
        this.livroServico.update(object);
        return new ResponseEntity<>(object, HttpStatus.CREATED);
    }

    @DeleteMapping("/livro")
    public ResponseEntity delete(@RequestBody LivroDTO object){
        this.livroServico.delete(object);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/livro/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id){
        this.livroServico.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
