package br.com.bibliotecaspring.servicos;

import br.com.bibliotecaspring.models.Autor;
import br.com.bibliotecaspring.models.Livro;
import br.com.bibliotecaspring.repositorios.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Qualifier("Autor")
@Service
public class AutorServico implements CrudServico<Autor, Long> {
    private AutorRepositorio autorRepositorio;
    public AutorServico(@Qualifier("AutorRepo") AutorRepositorio autorRepositorio){
        this.autorRepositorio = autorRepositorio;
    }
    @Override
    public List<Autor> findAll() {
        return autorRepositorio.findAll();
    }

    @Override
    public Autor findById(Long id) {
        return autorRepositorio.findById(id);
    }
    public List<Livro> findAllLivros(){ return autorRepositorio.findAllLivros(); }

    @Override
    public void save(Autor object) {
        autorRepositorio.save(object);
    }

    @Override
    public void delete(Autor object) {
        autorRepositorio.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        autorRepositorio.deleteById(id);
    }

    @Override
    public void updateById(Long id, Autor object) {
        Autor autor = this.findById(id);
        autor = object;
        autorRepositorio.save(autor);
    }
}
