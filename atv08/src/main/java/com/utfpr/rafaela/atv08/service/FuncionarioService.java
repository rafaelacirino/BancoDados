package com.utfpr.rafaela.atv08.service;

import com.utfpr.rafaela.atv08.entity.Departamento;
import com.utfpr.rafaela.atv08.entity.Funcionario;
import com.utfpr.rafaela.atv08.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FuncionarioService extends BaseService<Funcionario, Long, FuncionarioRepository> {
    public FuncionarioService(FuncionarioRepository repository) {
        super(repository);
    }

    public Funcionario findByNomeAndQuantidadeDependentes(String nome, Integer quantidadeDependentes) {
        return repository.findByNomeAndQuantidadeDependentes(nome, quantidadeDependentes);
    }

    public List<Funcionario> findByDepartamento(String departamento) { return repository.findByDepartamento(departamento); }

    public Funcionario findTopByOrderBySalarioDesc() { return repository.findTopByOrderBySalarioDesc(); }

    public List<Funcionario> findTop3ByOrderBySalarioDesc() { return repository.findTop3ByOrderBySalarioDesc(); }

    public List<Funcionario> findNotHavingDependentesOrderByNomeAsc() { return repository.findNotHavingDependentesOrderByNomeAsc(); }

    public List<Funcionario> findBySalarioGreatherThan(Double salario) { return repository.findBySalarioGreatherThan(salario); }

    public List<Funcionario> findBySalarioGreatherThanNative(Double salario) { return repository.findBySalarioGreatherThanNative(salario); }

    public List<Funcionario> findByQuantidadeDependentes(Integer quantidadeDependentes) { return repository.findByQuantidadeDependentes(quantidadeDependentes); }

    public List<Funcionario> findByNomeLike(String nome) { return repository.findByNomeLike(nome); }

    public Integer callAumentoSalarioFuncionarios(Integer porcentagem) { return repository.callAumentoSalarioFuncionarios(porcentagem); }

    public List<Funcionario> findByDepartamentoNotHavingDependentes(String departamento) { return repository.findByDepartamentoNotHavingDependentes(departamento); }

    @Transactional
    public Integer switchFuncionariosDepartamento(Departamento origem, Departamento destino) { return repository.switchFuncionariosDepartamento(origem, destino); }

    @Transactional
    public Integer deleteFuncionariosFromDepartamento(Departamento departamento) { return repository.deleteFuncionariosFromDepartamento(departamento); }
}
