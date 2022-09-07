package com.utfpr.rafaela.atv05.entity;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @Column(name = "cod_func")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "nome_dpto", nullable = false, length = 64)
    private String nome;

    @Column(name = "qtde_dep")
    private Integer qtde_dep;

    @Column(name = "salario", nullable = false)
    private Double salario;

    @Column(name = "cargo", nullable = false, length = 64)
    private String cargo;

    @ManyToOne(optional = true, fetch = LAZY)
    @JoinTable(name = "func_dpto",
                joinColumns = {@JoinColumn(name = "cod_func")},
                inverseJoinColumns = {@JoinColumn(name = "cod_dpto")})
    private Departamento departamento;

    public Funcionario() {
    }

    public Funcionario(String nome, Integer qtde_dep, Double salario, String cargo, Departamento departamento) {
        super();
        this.nome = nome;
        this.qtde_dep = qtde_dep;
        this.salario = salario;
        this.cargo = cargo;
        this.departamento = departamento;
    }

    public Funcionario(Long id, String nome, Integer qtde_dep, Double salario, String cargo, Departamento departamento) {
        this.id = id;
        this.nome = nome;
        this.qtde_dep = qtde_dep;
        this.salario = salario;
        this.cargo = cargo;
        this.departamento = departamento;
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

    public Integer getQtde_dep() {
        return qtde_dep;
    }

    public void setQtde_dep(Integer qtde_dep) {
        this.qtde_dep = qtde_dep;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
