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


    public void update(AutorDTO object) {
        Autor autor = new Autor();

        autor.setId(object.getId());
        autor.setNome(object.getNome());
        autor.setLivros(object.getLivros());

        autorRepositorio.save(autor);
    }

    private AutorDTO filterAutor(Autor autor){
        Set<Livro> livrosFiltrados = new HashSet<>();
        AutorDTO autorDTO = new AutorDTO();
        autorDTO.setId(autor.getId());
        autorDTO.setNome(autor.getNome());

        for(Livro livro : autor.getLivros()){
            livrosFiltrados.add(filterSetLivros(livro));
        }
        autorDTO.setLivros(livrosFiltrados);
        return autorDTO;
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
}
