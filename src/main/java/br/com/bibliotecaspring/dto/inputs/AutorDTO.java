package br.com.bibliotecaspring.dto.inputs;

import br.com.bibliotecaspring.models.Livro;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class AutorDTO {
    private Long id;
    private String nome;
    private Set<Livro> livros;
}
