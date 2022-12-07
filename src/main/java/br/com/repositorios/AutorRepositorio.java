package br.com.repositorios;

import br.com.models.Autor;
import br.com.models.Livro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AutorRepositorio extends RepositorioBase<Autor, Long> {
    List<Livro> findAllLivros();
}