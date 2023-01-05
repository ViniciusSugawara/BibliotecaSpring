package br.com.bibliotecaspring.dto.outputs;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class AutorLivrosSemAutoresDTO {
    private Long id;
    private String nome;
    private Set<LivroSemAutoresDTO> livros;
}
