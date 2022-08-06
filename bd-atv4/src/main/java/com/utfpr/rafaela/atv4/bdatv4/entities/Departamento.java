package com.utfpr.rafaela.atv4.bdatv4.entities;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento {

    @Id
    @Column(name = "id_departamento")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "nome_departamento", nullable = false, length = 64)
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Set<Funcionario> funcionarios;

    public Departamento(Long id, String nome, String endereco, Set<Funcionario> funcionarios) {
        this.id = id;
        this.nome = nome;
        this.funcionarios = funcionarios;
    }

    public Departamento() {
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

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", funcionarios=" + funcionarios +
                '}';
    }
}
