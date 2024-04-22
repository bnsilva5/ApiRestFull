package com.nicholassilva.PruebaTecnica.models.Dao;

import com.nicholassilva.PruebaTecnica.models.Entity.PlanEntregaTerrestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlanEntregaTerrestreDao extends JpaRepository<PlanEntregaTerrestre, Long> {
}
