package br.com.bibliotecaspring.servicos;

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
    public List<Autor> findAll() {
        List<Autor> listaFiltrada = new ArrayList<>();
        for(Autor autor : autorRepositorio.findAll()){
            listaFiltrada.add(filterAutor(autor));
        }
        return listaFiltrada;
    }
    private Autor filterAutor(Autor autor){
        Set<Livro> livrosFiltrados = new HashSet<>();
        Autor prototipo = new Autor();
        prototipo.setId(autor.getId());
        prototipo.setNome(autor.getNome());

        for(Livro livro : autor.getLivros()){
            livrosFiltrados.add(filterSetLivros(livro));
        }
        prototipo.setLivros(livrosFiltrados);
        return prototipo;
    }
    // Metodo criado para que nao seja retornado um conjunto redundante de autor, que eh lido dentro do JSON
    // causando erro de stack overflow.
    private Livro filterSetLivros(Livro livro){
        Livro livroPrototipo = new Livro();
        livroPrototipo.setId(livro.getId());
        livroPrototipo.setNome(livro.getNome());
        livroPrototipo.setIsbn(livro.getIsbn());
        return livroPrototipo;
    }
    public Autor findById(Long id) {
        return autorRepositorio.findById(id).orElse(null);
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
