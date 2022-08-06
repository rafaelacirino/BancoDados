package com.utfpr.rafaela.atv4.bdatv4.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AUTOR")
public class Autor {

    @Id
    @Column(name = "id_autor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_autor", nullable = false, length = 64)
    private String nome;

    @ManyToMany(mappedBy = "autores")
    private Set<Livro> livros;

    public Autor() {
    }

    public Autor(Long id, String nome, Set<Livro> livros) {
        this.id = id;
        this.nome = nome;
        this.livros = livros;
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

    public Set<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Set<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", livros=" + livros +
                '}';
    }
}
