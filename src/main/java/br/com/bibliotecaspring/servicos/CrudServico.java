package br.com.bibliotecaspring.servicos;

import java.util.List;

public interface CrudServico <T, ID>{
    List<T> findAll();
    T findById(ID id);
    void save(T object);
    void delete(T object);
    void deleteById(ID id);
    void updateById(ID id, T object);



}
