package com.utfpr.rafaela.atv4.bdatv4.entities;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario {

    @Id
    @Column(name = "id_funcionario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_funcionario", nullable = false, length = 64)
    private String nome;

    @JoinColumn(name = "id_departamento")
    @ManyToOne(optional = true, fetch = LAZY)
    private Departamento departamento;

    public Funcionario(Long id, String nome, Departamento departamento) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
    }

    public Funcionario() {
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}
