package org.entity;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produtos extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public float medida;
    
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    public Categoria categoria;
    
    @ManyToOne
    @JoinColumn(name = "medidas_id")
    public Medidas medidas;

    @OneToMany(mappedBy = "produtos")
    public List<Precos> precos;

    public Produtos() {}

    public Produtos( String nome, Medidas medidas, Categoria categoria) {
        this.nome = nome;
        this.categoria = categoria;
        this.medidas = medidas;
        this.medida = 0;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPrecos(List<Precos> precos) {
        this.precos = precos;
    }
    public String getNome() {
        return nome;
    }
    public List<Precos> getPrecos() {
        return precos;
    }
    public Long getId() {
        return id;
    }
    public Categoria getCategoria() {
        return categoria;
    }

    public Medidas getMedidas() {
        return medidas;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public void setMedidas(Medidas medidas) {
        this.medidas = medidas;
    }
}
