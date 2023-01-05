package br.com.bibliotecaspring.repositorios;

import br.com.bibliotecaspring.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long> {
}