package com.utfpr.rafaela.atv08.service;

import com.utfpr.rafaela.atv08.entity.Departamento;
import com.utfpr.rafaela.atv08.entity.Funcionario;
import com.utfpr.rafaela.atv08.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartamentoService extends BaseService<Departamento, Long, DepartamentoRepository>{
    private final FuncionarioService funcionarioService;

    public DepartamentoService(DepartamentoRepository repository, FuncionarioService funcionarioService) {
        super(repository);
        this.funcionarioService = funcionarioService;
    }

    public List<Departamento> findByNome(String nome) { return repository.findByNome(nome); }

    public Departamento findFirstBy() { return repository.findFirstBy(); }

    @Transactional(readOnly = false)
    public void salvarDepartamentoAssociandoFuncionario(Departamento departamento, Funcionario funcionario) {
        salvar(departamento);
        funcionario.setDepartamento(departamento);
        funcionarioService.salvar(funcionario);
    }
}
