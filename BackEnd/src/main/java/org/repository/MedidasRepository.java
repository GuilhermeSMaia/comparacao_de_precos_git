package org.repository;

import org.entity.Medidas;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MedidasRepository implements PanacheRepositoryBase<Medidas, Long> {

    public Medidas findByMedida(String medida) {
        return find("medida", medida).firstResult();
    }

    
}
