package br.com.bibliotecaspring.dto.inputs;

import br.com.bibliotecaspring.dto.BaseDTO;
import br.com.bibliotecaspring.models.Livro;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class AutorDTO extends BaseDTO {
    private String nome;
    private Set<Livro> livros;
}
