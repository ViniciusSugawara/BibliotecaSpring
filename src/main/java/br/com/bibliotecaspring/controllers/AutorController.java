package br.com.bibliotecaspring.controllers;

import br.com.bibliotecaspring.dto.AutorDTO;
import br.com.bibliotecaspring.models.Autor;
import br.com.bibliotecaspring.servicos.AutorServico;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping({"/findById"})
    @GetMapping
    public AutorDTO findById(@PathVariable("id") Long id){
        return autorServico.findById(id);
    }

    @RequestMapping("/returnMock")
    @GetMapping
    public Autor retornaAutor(){
        Autor autorMock = new Autor();
        autorMock.setNome("Joj");
        return autorMock;
    }

    @RequestMapping("/store")
    @PostMapping
    public void save(Autor object){
        this.autorServico.save(object);
    }
    @RequestMapping("/delete")
    @DeleteMapping
    public void delete(Autor object){
        this.autorServico.delete(object);
    }

    @RequestMapping("/deleteById")
    @DeleteMapping
    public void deleteById(Long id){
        this.autorServico.deleteById(id);
    }

}