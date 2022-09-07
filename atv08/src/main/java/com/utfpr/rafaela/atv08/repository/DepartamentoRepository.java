package com.utfpr.rafaela.atv08.repository;

import com.utfpr.rafaela.atv08.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    List<Departamento> findByNome(String nome);

    Departamento findFirstBy();

}
