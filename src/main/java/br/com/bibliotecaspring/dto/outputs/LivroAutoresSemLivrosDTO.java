package br.com.bibliotecaspring.dto.outputs;

import br.com.bibliotecaspring.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class LivroAutoresSemLivrosDTO extends BaseDTO {
    private String nome;
    private String isbn;
    private Set<AutorSemLivrosDTO> autores;
}
