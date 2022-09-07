package com.utfpr.rafaela.atv05.service;

import com.utfpr.rafaela.atv05.entity.Funcionario;
import com.utfpr.rafaela.atv05.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService extends BaseService<Funcionario, Long, FuncionarioRepository> {
    public FuncionarioService(FuncionarioRepository repository) {
        super(repository);
    }
}
