package br.com.bibliotecaspring.servicos;

import br.com.bibliotecaspring.models.Livro;
import br.com.bibliotecaspring.repositorios.LivroRepositorio;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Qualifier("Livro")
@Service
public class LivroServico {
    private LivroRepositorio livroRepositorio;

    public LivroServico(LivroRepositorio livroRepositorio){
        this.livroRepositorio = livroRepositorio;
    }

    public List<Livro> findAll() {
        return livroRepositorio.findAll();
    }

    public Livro findById(Long id) {
        return livroRepositorio.findById(id).orElse(null);
    }

    public void save(Livro object) {
        livroRepositorio.save(object);
    }


    public void delete(Livro object) {
        livroRepositorio.delete(object);
    }

    public void deleteById(Long id) {
        livroRepositorio.deleteById(id);
    }

    public void updateById(Long id, Livro object) {
        Livro livro = findById(id);
        livro = object;
        livroRepositorio.save(livro);
    }
}
