package com.utfpr.rafaela.atv4.bdatv4.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "LIVRO")
public class Livro {

    @Id
    @Column(name = "id_livro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo_livro", nullable = false, length = 150)
    private String titulo;

    @ManyToMany
    @JoinTable(name = "livros_autores",
            joinColumns = {
            @JoinColumn(name = "id_livro", foreignKey = @ForeignKey(name = "id_livro_fk"))
            },
            inverseJoinColumns = {
            @JoinColumn(name = "id_autor", foreignKey = @ForeignKey(name = "id_autor_fk"))
            }
            )
    private Set<Autor> autores;

    public Livro() {
    }

    public Livro(Long id, String titulo, Set<Autor> autores) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autores +
                '}';
    }
}
