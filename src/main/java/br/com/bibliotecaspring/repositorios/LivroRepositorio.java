package br.com.bibliotecaspring.repositorios;

import br.com.models.Livro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LivroRepositorio extends RepositorioBase<Livro, Long> {
}
