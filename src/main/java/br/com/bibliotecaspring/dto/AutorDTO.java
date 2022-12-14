package br.com.bibliotecaspring.dto;

import br.com.bibliotecaspring.models.Livro;

import java.util.Set;

public class AutorDTO {
    private Long id;
    private String nome;
    private Set<Livro> livros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Set<Livro> livros) {
        this.livros = livros;
    }
}
