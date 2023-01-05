package br.com.bibliotecaspring.dto.inputs;

import br.com.bibliotecaspring.models.Autor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class LivroDTO {
    private Long id;
    private String nome;
    private String isbn;
    private Set<Autor> autores;
}
