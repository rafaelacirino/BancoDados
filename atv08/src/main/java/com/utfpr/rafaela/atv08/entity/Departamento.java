package com.utfpr.rafaela.atv08.entity;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "departamento")
public class Departamento {
    @Id
    @Column(name = "cod_dpto")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "nome_dpto", nullable = false, length = 64)
    private String nome;

    @OneToMany(fetch = LAZY,
            mappedBy = "departamento")
    private Set<Funcionario> funcionarios;

    public Departamento() {
    }

    public Departamento(Long id, String nome, Set<Funcionario> funcionarios) {
        this.id = id;
        this.nome = nome;
        this.funcionarios = funcionarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
