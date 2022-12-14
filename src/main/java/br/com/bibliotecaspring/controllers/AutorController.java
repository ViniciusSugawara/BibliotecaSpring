package br.com.bibliotecaspring.controllers;

import br.com.bibliotecaspring.dto.AutorDTO;
import br.com.bibliotecaspring.models.Autor;
import br.com.bibliotecaspring.models.Livro;
import br.com.bibliotecaspring.servicos.AutorServico;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/autor")
public class AutorController {
    private AutorServico autorServico;

    public AutorController(AutorServico autorServico){
        this.autorServico = autorServico;
    }


    @RequestMapping("/index")
    @GetMapping
    public List<AutorDTO> findAll(){
        return autorServico.findAll();
    }

    @RequestMapping({"/index/{id}"})
    @GetMapping
    public AutorDTO findById(@PathVariable("id") Long id){
        return autorServico.findById(id);
    }
    @GetMapping("/index/{id}/livros")
    public Set<Livro> findAllLivrosById(@PathVariable("id") Long id){ return autorServico.findAllLivrosById(id);}

    @RequestMapping("/returnMock")
    @GetMapping
    public Autor retornaAutor(){
        Autor autorMock = new Autor();
        autorMock.setNome("Joj");
        return autorMock;
    }

    @RequestMapping("/store")
    @PostMapping
    public void save(@RequestBody Autor object){
        this.autorServico.save(object);
    }

    @PutMapping("/update")
    public void update(@RequestBody AutorDTO object) {
        this.autorServico.update(object);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Autor object){
        this.autorServico.delete(object);
    }

    @RequestMapping("/delete/{id}")
    @DeleteMapping
    public void deleteById(@PathVariable("id") Long id){
        this.autorServico.deleteById(id);
    }

}