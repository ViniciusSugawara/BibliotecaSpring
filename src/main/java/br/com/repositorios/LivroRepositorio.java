package br.com.repositorios;

import br.com.models.Livro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LivroRepositorio extends CrudRepository<Livro, Long> {
    List<Livro> findAll();
}
