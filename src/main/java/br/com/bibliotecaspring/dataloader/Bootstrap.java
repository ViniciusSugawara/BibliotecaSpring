package br.com.bibliotecaspring.dataloader;

import br.com.bibliotecaspring.models.Autor;
import br.com.bibliotecaspring.models.Livro;
import br.com.bibliotecaspring.repositorios.AutorRepositorio;
import br.com.bibliotecaspring.repositorios.LivroRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class Bootstrap implements CommandLineRunner {
    private final AutorRepositorio autorRepositorio;
    private final LivroRepositorio livroRepositorio;

    public Bootstrap(AutorRepositorio autorRepositorio, LivroRepositorio livroRepositorio) {
        this.autorRepositorio = autorRepositorio;
        this.livroRepositorio = livroRepositorio;
    }

    @Override
    public void run(String... args) throws Exception {
        Autor autor1 = new Autor();
        autor1.setNome("EhOsGuri");

        Livro livro1 = new Livro();
        livro1.setNome("Livrao top");
        livro1.setIsbn("713721391");

        livroRepositorio.save(livro1);

        autor1.getLivros().add(livro1);

        autorRepositorio.save(autor1);

        Autor autor2 = new Autor();
        autor2.setNome("aaaaaaaaaaa");

        autorRepositorio.save(autor2);
        System.out.println("Authors saved");
        }
}
