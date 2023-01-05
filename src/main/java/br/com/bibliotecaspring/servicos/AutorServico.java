package br.com.bibliotecaspring.servicos;

import br.com.bibliotecaspring.dto.inputs.AutorDTO;
import br.com.bibliotecaspring.dto.outputs.AutorLivrosSemAutoresDTO;
import br.com.bibliotecaspring.dto.outputs.LivroSemAutoresDTO;
import br.com.bibliotecaspring.models.Autor;
import br.com.bibliotecaspring.models.Livro;
import br.com.bibliotecaspring.repositorios.AutorRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Qualifier("Autor")
@Service
public class AutorServico implements IServico<AutorDTO, AutorLivrosSemAutoresDTO, Long> {
    private AutorRepositorio autorRepositorio;
    private ModelMapper modelMapper = new ModelMapper();
    public AutorServico(AutorRepositorio autorRepositorio){
        this.autorRepositorio = autorRepositorio;
    }
    public List<AutorLivrosSemAutoresDTO> findAll() {
        List<AutorLivrosSemAutoresDTO> listaFiltrada = new ArrayList<>();
        for(Autor autor : autorRepositorio.findAll()){
            listaFiltrada.add(this.modelMapper.map(autor, AutorLivrosSemAutoresDTO.class));
        }
        return listaFiltrada;
    }

    public AutorLivrosSemAutoresDTO findById(Long id) {
        return this.modelMapper.map(autorRepositorio.findById(id).orElse(null), AutorLivrosSemAutoresDTO.class);
    }

    public Set<LivroSemAutoresDTO> findAllLivrosById(Long id){
        return this.modelMapper.map(autorRepositorio.findById(id).orElse(null), AutorLivrosSemAutoresDTO.class).getLivros();
    }

    public AutorDTO save(AutorDTO object) {
        autorRepositorio.save(this.modelMapper.map(object, Autor.class));
        return object;
    }

    public void delete(AutorDTO object) {
        autorRepositorio.delete(this.modelMapper.map(object, Autor.class));
    }

    public void deleteById(Long id) {
        autorRepositorio.deleteById(id);
    }

    public AutorDTO update(AutorDTO object) {
        autorRepositorio.save(this.modelMapper.map(object, Autor.class));
        return object;
    }
}
