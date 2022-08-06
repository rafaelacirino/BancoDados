package com.utfpr.rafaela.atv4.bdatv4.entities;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "PEDIDO")
public class Pedido {

    @Column(name = "id_pedido")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_pedido", nullable = false, length = 150)
    private String nome;

    @ManyToOne(optional = true, fetch = LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(Long id, String nome, Cliente cliente) {
        this.id = id;
        this.nome = nome;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
