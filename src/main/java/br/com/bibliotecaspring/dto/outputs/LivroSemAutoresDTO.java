package br.com.bibliotecaspring.dto.outputs;

import br.com.bibliotecaspring.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroSemAutoresDTO extends BaseDTO {
    private String nome;
    private String isbn;
}
