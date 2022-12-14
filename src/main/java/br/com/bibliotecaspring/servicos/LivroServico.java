package br.com.bibliotecaspring.servicos;

import br.com.bibliotecaspring.dto.LivroDTO;
import br.com.bibliotecaspring.models.Autor;
import br.com.bibliotecaspring.models.Livro;
import br.com.bibliotecaspring.repositorios.LivroRepositorio;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Qualifier("Livro")
@Service
public class LivroServico {
    private LivroRepositorio livroRepositorio;

    public LivroServico(LivroRepositorio livroRepositorio){
        this.livroRepositorio = livroRepositorio;
    }

    public List<LivroDTO> findAll() {
        List<LivroDTO> listaFiltrada = new ArrayList<>();
        for(Livro livro : livroRepositorio.findAll()){
            listaFiltrada.add(filterLivro(livro));
        }
        return listaFiltrada;
    }


    public LivroDTO findById(Long id) {
        return filterLivro(livroRepositorio.findById(id).orElse(null));
    }

    public void save(Livro object) {
        livroRepositorio.save(object);
    }


    public void delete(Livro object) {
        livroRepositorio.delete(object);
    }

    public void deleteById(Long id) {
        livroRepositorio.deleteById(id);
    }

    public void update(LivroDTO object) {
        Livro livro = new Livro();

        livro.setId(object.getId());
        livro.setNome(object.getNome());
        livro.setIsbn(object.getIsbn());
        livro.setAutores(object.getAutores());

        livroRepositorio.save(livro);
    }

    private LivroDTO filterLivro(Livro livro){
        Set<Autor> autoresFiltrados = new HashSet<>();
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livro.getId());
        livroDTO.setIsbn(livro.getIsbn());
        livroDTO.setNome(livro.getNome());

        for(Autor autor : livro.getAutores()){
            autoresFiltrados.add(filterSetAutores(autor));
        }
        livroDTO.setAutores(autoresFiltrados);
        return livroDTO;
    }
    private Autor filterSetAutores(Autor autor){
        Autor autorPrototipo = new Autor();
        autorPrototipo.setId(autor.getId());
        autorPrototipo.setNome(autor.getNome());
        return autorPrototipo;
    }
}
