package com.utfpr.rafaela.atv07.repository;

import com.utfpr.rafaela.atv07.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    List<Departamento> findByNome(String nome);

    Departamento findFirstBy();

}
