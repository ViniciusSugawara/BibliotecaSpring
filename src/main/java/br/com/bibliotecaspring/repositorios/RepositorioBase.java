package br.com.bibliotecaspring.repositorios;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
@NoRepositoryBean
public interface RepositorioBase<T, ID>{
    void save (T object);
    List<T> findAll();
    T findById(ID id);
    void delete(T object);
    void deleteById(ID id);
}
