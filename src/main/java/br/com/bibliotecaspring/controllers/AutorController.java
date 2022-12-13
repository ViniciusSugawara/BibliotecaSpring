package br.com.bibliotecaspring.controllers;

import br.com.bibliotecaspring.models.Autor;
import br.com.bibliotecaspring.servicos.CrudServico;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Qualifier("AutorController")
public class AutorController {
    private AutorServico autorServico;

    public AutorController(AutorServico autorServico){
        this.autorServico = autorServico;
    }

    @RequestMapping({"/achaAutores"})
    public Autor findById(Long id){
        return (Autor) autorServico.findById(id);
    }

    @RequestMapping("/testeApi")
    @GetMapping
    public Autor retornaAutor(){
        Autor autorMock = new Autor();
        autorMock.setNome("Joj");
        return autorMock;
    }

    @RequestMapping("/achaTodos")
    public List<Autor> findAll(){
        return (List<Autor>) autorServico.findAll();
    }

    @RequestMapping("/insereAutor")
    @PostMapping
    public void save(Autor object){
        this.autorServico.save(object);
    }

}