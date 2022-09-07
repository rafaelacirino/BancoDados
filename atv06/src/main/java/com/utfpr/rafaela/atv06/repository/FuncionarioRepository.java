package com.utfpr.rafaela.atv06.repository;

import com.utfpr.rafaela.atv06.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByNomeAndQtdeDependentes(String nome, Integer qtdeDependentes);

    @Query("SELECT f FROM Funcionario f WHERE f.departamento.nome like ?1")
    List<Funcionario> findByDepartamento(String departamento);

    List<Funcionario> findTop3ByOrderBySalarioDesc();

    @Query("SELECT f FROM Funcionario f WHERE f.qtdeDependentes = 0 ORDER BY f.nome ASC")
    List<Funcionario> findNotHavingDependentesOrderByNomeAsc();

    @Query("SELECT f FROM Funcionario f WHERE f.salario > ?1")
    List<Funcionario> findBySalarioGreatherThan(Double salario);

    @Query(nativeQuery = true, value = "SELECT f.*, NULL AS cod_departamento FROM funcionario f WHERE f.salario > ?1")
    List<Funcionario> findBySalarioGreatherThanNative(Double salario);

    @Query(name = "findByQuantidadeDependentes")
    List<Funcionario> findByQuantidadeDependentes(Integer quantidadeDependentes);

    @Query(name = "findByNomeLike")
    List<Funcionario> findByNomeLike(String nome);
}
