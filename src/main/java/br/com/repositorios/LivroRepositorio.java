package br.com.repositorios;

import br.com.models.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepositorio extends CrudRepository<Livro, Long> {
}
