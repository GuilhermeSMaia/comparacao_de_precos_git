package org.repository;

import org.entity.Categoria;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoriaRepository implements PanacheRepositoryBase<Categoria, Long> {

    public Categoria findByCategoria(String categoria) {
        return find("categoria", categoria).firstResult();
    }


    
}
