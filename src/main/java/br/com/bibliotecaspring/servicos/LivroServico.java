package br.com.bibliotecaspring.servicos;

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

    public List<Livro> findAll() {
        List<Livro> listaFiltrada = new ArrayList<>();
        for(Livro livro : livroRepositorio.findAll()){
            listaFiltrada.add(filterLivro(livro));
        }
        return listaFiltrada;
    }
    private Livro filterLivro(Livro livro){
        Livro prototipo = new Livro();
        Set<Autor> autoresFiltrados = new HashSet<>();
        prototipo.setId(livro.getId());
        prototipo.setIsbn(livro.getIsbn());
        prototipo.setNome(livro.getNome());

        for(Autor autor : livro.getAutor()){
            autoresFiltrados.add(autor);
        }
        prototipo.setAutor(autoresFiltrados);
        return prototipo;
    }
    private Autor filterSetAutores(Autor autor){
        Autor autorPrototipo = new Autor();
        autorPrototipo.setId(autor.getId());
        autorPrototipo.setNome(autor.getNome());
        return autorPrototipo;
    }

    public Livro findById(Long id) {
        return livroRepositorio.findById(id).orElse(null);
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

    public void updateById(Long id, Livro object) {
        Livro livro = findById(id);
        livro = object;
        livroRepositorio.save(livro);
    }
}
