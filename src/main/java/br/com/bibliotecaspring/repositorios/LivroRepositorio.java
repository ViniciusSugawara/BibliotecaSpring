package br.com.bibliotecaspring.repositorios;

import br.com.bibliotecaspring.models.Livro;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("LivroRepo")
public interface LivroRepositorio extends RepositorioBase<Livro, Long> {
}
