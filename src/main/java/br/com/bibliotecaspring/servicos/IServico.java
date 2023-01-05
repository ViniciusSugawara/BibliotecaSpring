package br.com.bibliotecaspring.servicos;

import java.util.List;

public interface IServico<T_input, T_output, ID> {
    List<T_output> findAll();
    T_output findById(ID id);
    T_input save(T_input object);
    T_input update(T_input object);
    void delete(T_input object);
    void deleteById(ID id);
}
