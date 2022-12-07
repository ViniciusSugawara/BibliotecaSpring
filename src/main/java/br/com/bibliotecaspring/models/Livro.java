package br.com.bibliotecaspring.models;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String nome;
    private String isbn;
    private Autor autor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(Id, livro.Id) && Objects.equals(nome, livro.nome) && Objects.equals(isbn, livro.isbn) && Objects.equals(autor, livro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, nome, isbn, autor);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "Id=" + Id +
                ", nome='" + nome + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor=" + autor +
                '}';
    }
}