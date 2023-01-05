package br.com.bibliotecaspring.dto.outputs;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class LivroAutoresSemLivrosDTO {
    private Long id;
    private String nome;
    private String isbn;
    private Set<AutorSemLivrosDTO> autores;
}
