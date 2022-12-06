package br.com.repositorios;

import br.com.models.Autor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AutorRepositorio extends CrudRepository<Autor, Long> {
    List<Autor> findAll();
}
