package br.com.bibliotecaspring.controllers;

import br.com.bibliotecaspring.dto.inputs.AutorDTO;
import br.com.bibliotecaspring.dto.outputs.AutorLivrosSemAutoresDTO;
import br.com.bibliotecaspring.dto.outputs.LivroSemAutoresDTO;
import br.com.bibliotecaspring.models.Autor;
import br.com.bibliotecaspring.servicos.AutorServico;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class AutorController implements IController<AutorDTO, AutorLivrosSemAutoresDTO> {
    private AutorServico servico;

    public AutorController(@Qualifier("Autor") AutorServico servico){
        this.servico = servico;
    }

    @GetMapping("/autores")
    @Override
    public ResponseEntity<List<AutorLivrosSemAutoresDTO>> findAll(){
        return new ResponseEntity<>(servico.findAll(), HttpStatus.OK);
    }

    @GetMapping("/autor/{id}")
    @Override
    public ResponseEntity<AutorLivrosSemAutoresDTO> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>( (AutorLivrosSemAutoresDTO) servico.findById(id), HttpStatus.OK);
    }
    @GetMapping("/autor/{id}/livros")
    public Set<LivroSemAutoresDTO> findAllLivrosById(@PathVariable("id") Long id){
        return servico.findAllLivrosById(id);
    }

    @GetMapping("/autor/returnMock")
    public Autor retornaAutor(){
        Autor autorMock = new Autor();
        autorMock.setNome("Joj");
        return autorMock;
    }

    @PostMapping("/autor")
    @Override
    public ResponseEntity<AutorDTO> save(@RequestBody AutorDTO object){
        this.servico.save(object);
        return new ResponseEntity<>(object, HttpStatus.CREATED);
    }

    @PutMapping("/autor")
    @Override
    public ResponseEntity<AutorDTO> update(@RequestBody AutorDTO object) {
        this.servico.update(object);
        return new ResponseEntity<>(object,HttpStatus.CREATED);
    }

    @DeleteMapping("/autor")
    @Override
    public ResponseEntity delete(@RequestBody AutorDTO object){
        this.servico.delete(object);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/autor/{id}")
    @Override
    public ResponseEntity deleteById(@PathVariable("id") Long id){
        this.servico.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}