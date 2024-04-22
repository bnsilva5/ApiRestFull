package com.nicholassilva.PruebaTecnica.Services;

import com.nicholassilva.PruebaTecnica.models.Entity.PlanEntregaTerrestre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPlanEntregaTerrestreService {

    public Page<PlanEntregaTerrestre> findAll(Pageable pageable);
    public PlanEntregaTerrestre findById(Long id);
    public PlanEntregaTerrestre save(PlanEntregaTerrestre planEntregaTerrestre);
    public void delete(Long id);
}
