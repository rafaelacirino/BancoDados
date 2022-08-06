package com.utfpr.rafaela.atv4.bdatv4.entities;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.DETACH;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "nome_cliente", nullable = false, length = 64)
    private String nome;

    @OneToMany(cascade = DETACH, orphanRemoval = false, mappedBy = "id_pedido")
    private Set<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(Long id, String nome, Set<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.pedidos = pedidos;
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

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pedidos=" + pedidos +
                '}';
    }
}
