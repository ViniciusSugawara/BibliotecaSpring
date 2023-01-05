package br.com.bibliotecaspring.servicos;

import br.com.bibliotecaspring.dto.inputs.LivroDTO;
import br.com.bibliotecaspring.dto.outputs.AutorLivrosSemAutoresDTO;
import br.com.bibliotecaspring.dto.outputs.AutorSemLivrosDTO;
import br.com.bibliotecaspring.dto.outputs.LivroAutoresSemLivrosDTO;
import br.com.bibliotecaspring.dto.outputs.LivroSemAutoresDTO;
import br.com.bibliotecaspring.models.Autor;
import br.com.bibliotecaspring.models.Livro;
import br.com.bibliotecaspring.repositorios.LivroRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Qualifier("Livro")
@Service
public class LivroServico {
    private LivroRepositorio livroRepositorio;
    private ModelMapper modelMapper = new ModelMapper();

    public LivroServico(LivroRepositorio livroRepositorio){
        this.livroRepositorio = livroRepositorio;
    }

    public List<LivroAutoresSemLivrosDTO> findAll() {
        List<LivroAutoresSemLivrosDTO> listaFiltrada = new ArrayList<>();
        for(Livro livro : livroRepositorio.findAll()){
            listaFiltrada.add(this.modelMapper.map(livro, LivroAutoresSemLivrosDTO.class));
        }
        return listaFiltrada;
    }


    public LivroAutoresSemLivrosDTO findById(Long id) {
        return this.modelMapper.map(livroRepositorio.findById(id).orElse(null), LivroAutoresSemLivrosDTO.class);
    }

    public void save(LivroDTO object) {
        livroRepositorio.save(this.modelMapper.map(object, Livro.class));
    }

    public void delete(LivroDTO object) {
        livroRepositorio.delete(this.modelMapper.map(object, Livro.class));
    }

    public void deleteById(Long id) {
        livroRepositorio.deleteById(id);
    }

    public void update(LivroDTO object) {
        livroRepositorio.save(this.modelMapper.map(object, Livro.class));
    }
}
