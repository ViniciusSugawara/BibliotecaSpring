package br.com.bibliotecaspring.controllers;

import br.com.bibliotecaspring.dto.AutorDTO;
import br.com.bibliotecaspring.models.Autor;
import br.com.bibliotecaspring.models.Livro;
import br.com.bibliotecaspring.servicos.AutorServico;
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
    public List<AutorDTO> findAll(){
        return autorServico.findAll();
    }

    @GetMapping("/autor/{id}")
    public AutorDTO findById(@PathVariable("id") Long id){
        return autorServico.findById(id);
    }
    @GetMapping("/autor/{id}/livros")
    public Set<Livro> findAllLivrosById(@PathVariable("id") Long id){ return autorServico.findAllLivrosById(id);}

    @GetMapping("/autor/returnMock")
    public Autor retornaAutor(){
        Autor autorMock = new Autor();
        autorMock.setNome("Joj");
        return autorMock;
    }

    @PostMapping("/autor")
    public void save(@RequestBody Autor object){
        this.autorServico.save(object);
    }

    @PutMapping("/autor")
    public void update(@RequestBody AutorDTO object) {
        this.autorServico.update(object);
    }

    @DeleteMapping("/autor")
    public void delete(@RequestBody Autor object){
        this.autorServico.delete(object);
    }

    @DeleteMapping("/autor/{id}")
    public void deleteById(@PathVariable("id") Long id){
        this.autorServico.deleteById(id);
    }

}