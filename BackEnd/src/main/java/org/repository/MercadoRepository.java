package org.repository;

import org.entity.Mercados;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class MercadoRepository implements PanacheRepositoryBase<Mercados, Long> {

    public Mercados findByName(String name) {
        return find("nome", name).firstResult();
    }
    
}
