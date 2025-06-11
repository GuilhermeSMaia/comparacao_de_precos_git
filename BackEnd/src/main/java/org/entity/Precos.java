package org.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "precos")
public class Precos extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public BigDecimal preco;

    public LocalDate ultimaAtualizacao;
 
    @ManyToOne
    @JoinColumn(name = "mercados_id")
    public Mercados mercados;
    
    @ManyToOne
    @JoinColumn(name = "produtos_id")
    public Produtos produtos;
   
    public Precos() {}

    public Precos(BigDecimal preco, Mercados mercados, Produtos produtos) {
        this.preco = preco;
        this.mercados = mercados;
        this.produtos = produtos;
        ultimaAtualizacao = LocalDate.now();
    }


    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public BigDecimal getPreco() {
        return preco;
    }

    public Mercados getMercados() {
        return mercados;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public LocalDate getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDate ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
    
}
