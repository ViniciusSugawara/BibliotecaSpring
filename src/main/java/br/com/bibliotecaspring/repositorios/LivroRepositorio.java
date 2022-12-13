package br.com.bibliotecaspring.repositorios;

import br.com.bibliotecaspring.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepositorio extends JpaRepository<Livro, Long> {
}
