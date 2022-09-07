package com.utfpr.rafaela.atv05.repository;

import com.utfpr.rafaela.atv05.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    List<Departamento> findBynome(String nome);

}
