package br.com.bibliotecaspring.dto.outputs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroSemAutoresDTO {
    private Long id;
    private String nome;
    private String isbn;
}
