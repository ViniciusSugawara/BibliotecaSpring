package br.com.bibliotecaspring.dataloader;

import br.com.bibliotecaspring.models.Autor;
import br.com.bibliotecaspring.models.Livro;
import br.com.bibliotecaspring.repositorios.AutorRepositorio;
import br.com.bibliotecaspring.repositorios.LivroRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        autor1.setNome("Igor Viana");
        autorRepositorio.save(autor1);

        Livro livro1 = new Livro();
        livro1.setNome("A sociedade do Anel");
        livro1.setIsbn("8595084750");
        livro1.getAutores().add(autor1);

        livroRepositorio.save(livro1);

        Livro livro2 = new Livro();
        livro2.setNome("As duas torres");
        livro2.setIsbn("8595084769");
        livro2.getAutores().add(autor1);

        livroRepositorio.save(livro2);

        Livro livro3 = new Livro();
        livro3.setNome("O retorno do rei");
        livro3.setIsbn("8595084777");
        livro3.getAutores().add(autor1);

        livroRepositorio.save(livro3);

        System.out.println("Books saved");

        Autor autor2 = new Autor();
        autor2.setNome("Lucas Diovani");
        autor2.getLivros().add(livro1);
        autor2.getLivros().add(livro2);

        autorRepositorio.save(autor2);
        System.out.println("Authors saved");
    }
}
