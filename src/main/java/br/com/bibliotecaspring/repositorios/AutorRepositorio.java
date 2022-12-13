package br.com.bibliotecaspring.repositorios;

import br.com.bibliotecaspring.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositorio extends JpaRepository<Autor, Long> {
}