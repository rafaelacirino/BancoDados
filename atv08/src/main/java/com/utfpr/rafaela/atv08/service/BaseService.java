package com.utfpr.rafaela.atv08.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class BaseService<T, I, R extends JpaRepository<T, I>> {
    protected final R repository;

    public BaseService(R repository) {
        this.repository = repository;
    }

    public void salvar(T entity){
        repository.save(entity);
    }

    public Optional<T> buscarPorId(I id){
        return repository.findById(id);
    }

    public List<T> buscarTodos(){
        return repository.findAll();
    }

    public void excluir(T entity){
        repository.delete(entity);
    }
}
