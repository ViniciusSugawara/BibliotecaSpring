package br.com.bibliotecaspring.repositorios;

import br.com.bibliotecaspring.models.Autor;
import br.com.bibliotecaspring.models.Livro;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AutorRepositorio extends RepositorioBase<Autor, Long> {
    List<Livro> findAllLivros();
}