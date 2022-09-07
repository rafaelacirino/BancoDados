package com.utfpr.rafaela.atv06.service;

import com.utfpr.rafaela.atv06.entity.Departamento;
import com.utfpr.rafaela.atv06.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoService extends BaseService<Departamento, Long, DepartamentoRepository>{
    public DepartamentoService(DepartamentoRepository repository) {
        super(repository);
    }
}
