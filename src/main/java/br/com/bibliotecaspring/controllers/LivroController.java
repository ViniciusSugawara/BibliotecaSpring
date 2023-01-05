package br.com.bibliotecaspring.controllers;

import br.com.bibliotecaspring.dto.inputs.LivroDTO;
import br.com.bibliotecaspring.dto.outputs.LivroAutoresSemLivrosDTO;
import br.com.bibliotecaspring.models.Livro;
import br.com.bibliotecaspring.servicos.IServico;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivroController implements IController<LivroDTO, LivroAutoresSemLivrosDTO> {
    private IServico servico;
    public LivroController(@Qualifier("Livro") IServico servico){
        this.servico = servico;
    }

    @GetMapping("/livros")
    @Override
    public ResponseEntity<List<LivroAutoresSemLivrosDTO>> findAll(){
        return new ResponseEntity<>(servico.findAll(), HttpStatus.OK);
    }

    @GetMapping("/livro/{id}")
    @Override
    public ResponseEntity<LivroAutoresSemLivrosDTO> findById(@PathVariable("id") Long id){
        return new ResponseEntity(servico.findById(id), HttpStatus.OK);
    }

    @GetMapping("/livro/returnMock")
    public Livro retornaLivro(){
        Livro LivroMock = new Livro();
        LivroMock.setNome("AErfj9-0wossfkweo0");
        return LivroMock;
    }

    @PostMapping("/livro")
    @Override
    public ResponseEntity<LivroDTO> save(@RequestBody LivroDTO object){
        this.servico.save(object);
        return new ResponseEntity<>(object, HttpStatus.CREATED);
    }
    @PutMapping("/livro")
    @Override
    public ResponseEntity<LivroDTO> update(@RequestBody LivroDTO object){
        this.servico.update(object);
        return new ResponseEntity<>(object, HttpStatus.CREATED);
    }

    @DeleteMapping("/livro")
    @Override
    public ResponseEntity delete(@RequestBody LivroDTO object){
        this.servico.delete(object);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/livro/{id}")
    @Override
    public ResponseEntity deleteById(@PathVariable("id") Long id){
        this.servico.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
