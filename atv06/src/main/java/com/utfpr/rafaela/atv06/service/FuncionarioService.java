package com.utfpr.rafaela.atv06.service;

import com.utfpr.rafaela.atv06.entity.Funcionario;
import com.utfpr.rafaela.atv06.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService extends BaseService<Funcionario, Long, FuncionarioRepository> {
    public FuncionarioService(FuncionarioRepository repository) {
        super(repository);
    }
}
