package br.com.bibliotecaspring.servicos;

import br.com.bibliotecaspring.dto.AutorDTO;
import br.com.bibliotecaspring.dto.LivroDTO;
import br.com.bibliotecaspring.models.Autor;
import br.com.bibliotecaspring.models.Livro;
import br.com.bibliotecaspring.repositorios.AutorRepositorio;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Qualifier("Autor")
@Service
public class AutorServico {
    private AutorRepositorio autorRepositorio;
    public AutorServico(AutorRepositorio autorRepositorio){
        this.autorRepositorio = autorRepositorio;
    }
    public List<AutorDTO> findAll() {
        List<AutorDTO> listaFiltrada = new ArrayList<>();
        for(Autor autor : autorRepositorio.findAll()){
            listaFiltrada.add(filterAutor(autor));
        }
        return listaFiltrada;
    }

    public AutorDTO findById(Long id) {
        return filterAutor(autorRepositorio.findById(id).orElse(null));
    }

    public void save(Autor object) {
        autorRepositorio.save(object);
    }


    public void delete(Autor object) {
        autorRepositorio.delete(object);
    }


    public void deleteById(Long id) {
        autorRepositorio.deleteById(id);
    }


    public void updateById(Long id, Autor object) {
        Autor autor = this.findById(id);
        autor = object;
        autorRepositorio.save(autor);
    }
}
