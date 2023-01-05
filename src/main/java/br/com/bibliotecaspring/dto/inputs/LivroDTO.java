package br.com.bibliotecaspring.dto.inputs;

import br.com.bibliotecaspring.dto.BaseDTO;
import br.com.bibliotecaspring.models.Autor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class LivroDTO extends BaseDTO {
    private String nome;
    private String isbn;
    private Set<Autor> autores;
}
