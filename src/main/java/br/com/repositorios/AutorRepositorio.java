package br.com.repositorios;

import br.com.models.Autor;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepositorio extends CrudRepository<Autor, Long> {
}
