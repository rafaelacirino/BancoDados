package com.utfpr.rafaela.atv07.repository;

import com.utfpr.rafaela.atv07.entity.Departamento;
import com.utfpr.rafaela.atv07.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByNomeAndQuantidadeDependentes(String nome, Integer quantidadeDependentes);

    @Query("SELECT f FROM Funcionario f WHERE f.departamento.nome like ?1")
    List<Funcionario> findByDepartamento(String departamento);

    Funcionario findTopByOrderBySalarioDesc();

    List<Funcionario> findTop3ByOrderBySalarioDesc();

    @Query("SELECT f FROM Funcionario f WHERE f.quantidadeDependentes = 0 ORDER BY f.nome ASC")
    List<Funcionario> findNotHavingDependentesOrderByNomeAsc();

    @Query("SELECT f FROM Funcionario f WHERE f.salario > ?1")
    List<Funcionario> findBySalarioGreatherThan(Double salario);

    @Query(nativeQuery = true, value = "SELECT f.*, NULL AS cod_departamento FROM funcionario f WHERE f.salario > ?1")
    List<Funcionario> findBySalarioGreatherThanNative(Double salario);

    @Query(name = "findByQuantidadeDependentes")
    List<Funcionario> findByQuantidadeDependentes(Integer quantidadeDependentes);

    @Query(name = "findByNomeLike")
    List<Funcionario> findByNomeLike(String nome);

    @Procedure("aumentoSalarioFuncionario")
    Integer callAumentoSalarioFuncionarios(Integer porcentagem);

    @Query("SELECT f FROM Funcionario f WHERE f.quantidadeDependentes = 0 AND f.departamento.nome like :dpto")
    List<Funcionario> findByDepartamentoNotHavingDependentes(@Param("dpto") String departamento);

    @Modifying
    @Query("UPDATE Funcionario f SET f.departamento = :destino WHERE f.departamento = :origem")
    Integer switchFuncionariosDepartamento(@Param("origem") Departamento origem, @Param("destino") Departamento destino);

    @Modifying
    @Query("DELETE Funcionario f WHERE f.departamento = ?1")
    Integer deleteFuncionariosFromDepartamento(Departamento departamento);
}
