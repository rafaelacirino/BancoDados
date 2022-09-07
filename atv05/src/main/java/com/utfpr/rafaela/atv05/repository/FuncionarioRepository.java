package com.utfpr.rafaela.atv05.repository;

import com.utfpr.rafaela.atv05.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
