package br.com.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;
import java.util.Set;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String nome;
    private Set<Livro> livros;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(ID, autor.ID) && Objects.equals(nome, autor.nome) && Objects.equals(livros, autor.livros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, nome, livros);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "ID=" + ID +
                ", nome='" + nome + '\'' +
                ", livros=" + livros +
                '}';
    }
}
