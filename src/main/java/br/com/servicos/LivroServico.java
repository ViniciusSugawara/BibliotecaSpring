package br.com.servicos;

import br.com.models.Livro;
import br.com.repositorios.LivroRepositorio;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Qualifier("Livro")
public class LivroServico implements CrudServico<Livro, Long> {
    private LivroRepositorio livroRepositorio;

    public LivroServico(LivroRepositorio livroRepositorio){
        this.livroRepositorio = livroRepositorio;
    }
    @Override
    public List<Livro> findAll() {
        return livroRepositorio.findAll();
    }

    @Override
    public Livro findById(Long id) {
        return livroRepositorio.findById(id).orElse(null);
    }

    @Override
    public void save(Livro object) {
        livroRepositorio.save(object);
    }

    @Override
    public void delete(Livro object) {
        livroRepositorio.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        livroRepositorio.deleteById(id);
    }

    @Override
    public void updateById(Long id, Livro object) {
        Livro livro = findById(id);
        livro = object;
        livroRepositorio.save(livro);
    }
}
