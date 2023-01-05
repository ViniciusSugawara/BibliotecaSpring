package br.com.bibliotecaspring.controllers;

import br.com.bibliotecaspring.dto.inputs.AutorDTO;
import br.com.bibliotecaspring.dto.outputs.AutorLivrosSemAutoresDTO;
import br.com.bibliotecaspring.dto.outputs.LivroSemAutoresDTO;
import br.com.bibliotecaspring.models.Autor;
import br.com.bibliotecaspring.servicos.AutorServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class AutorController {
    private AutorServico autorServico;

    public AutorController(AutorServico autorServico){
        this.autorServico = autorServico;
    }

    @GetMapping("/autores")
    public ResponseEntity<List<AutorLivrosSemAutoresDTO>> findAll(){
        return new ResponseEntity<>(autorServico.findAll(), HttpStatus.OK);
    }

    @GetMapping("/autor/{id}")
    public ResponseEntity<AutorLivrosSemAutoresDTO> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(autorServico.findById(id), HttpStatus.OK);
    }
    @GetMapping("/autor/{id}/livros")
    public Set<LivroSemAutoresDTO> findAllLivrosById(@PathVariable("id") Long id){ return autorServico.findAllLivrosById(id);}

    @GetMapping("/autor/returnMock")
    public Autor retornaAutor(){
        Autor autorMock = new Autor();
        autorMock.setNome("Joj");
        return autorMock;
    }

    @PostMapping("/autor")
    public ResponseEntity<AutorDTO> save(@RequestBody AutorDTO object){
        this.autorServico.save(object);
        return new ResponseEntity<>(object, HttpStatus.CREATED);
    }

    @PutMapping("/autor")
    public ResponseEntity<AutorDTO> update(@RequestBody AutorDTO object) {
        this.autorServico.update(object);
        return new ResponseEntity<>(object,HttpStatus.CREATED);
    }

    @DeleteMapping("/autor")
    public ResponseEntity delete(@RequestBody AutorDTO object){
        this.autorServico.delete(object);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/autor/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id){
        this.autorServico.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}