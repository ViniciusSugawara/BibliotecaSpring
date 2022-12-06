package br.com.servicos;

import br.com.models.Autor;
import br.com.repositorios.AutorRepositorio;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Qualifier("Autor")
public class AutorServico implements CrudServico<Autor, Long> {
    private AutorRepositorio autorRepositorio;
    public AutorServico(AutorRepositorio autorRepositorio){
        this.autorRepositorio = autorRepositorio;
    }
    @Override
    public List<Autor> findAll() {
        return autorRepositorio.findAll();
    }

    @Override
    public Autor findById(Long id) {
        return autorRepositorio.findById(id).orElse(null);
    }

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
