package com.utfpr.rafaela.atv07.service;

import com.utfpr.rafaela.atv07.entity.Departamento;
import com.utfpr.rafaela.atv07.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService extends BaseService<Departamento, Long, DepartamentoRepository>{
    public DepartamentoService(DepartamentoRepository repository) {
        super(repository);
    }

    public List<Departamento> findByNome(String nome) { return repository.findByNome(nome); }

    public Departamento findFirstBy() { return repository.findFirstBy(); }
}
