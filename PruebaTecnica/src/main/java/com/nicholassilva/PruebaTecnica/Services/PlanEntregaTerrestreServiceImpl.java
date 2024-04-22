package com.nicholassilva.PruebaTecnica.Services;

import com.nicholassilva.PruebaTecnica.models.Dao.IPlanEntregaTerrestreDao;
import com.nicholassilva.PruebaTecnica.models.Entity.PlanEntregaTerrestre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanEntregaTerrestreServiceImpl implements IPlanEntregaTerrestreService{

    @Autowired
    private IPlanEntregaTerrestreDao planEntregaTerrestreDao;

    @Override
    @Transactional(readOnly = true)
    public Page<PlanEntregaTerrestre> findAll(Pageable pageable) {
        return planEntregaTerrestreDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public PlanEntregaTerrestre findById(Long id) {
        return planEntregaTerrestreDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public PlanEntregaTerrestre save(PlanEntregaTerrestre planEntregaTerrestre) {
        return planEntregaTerrestreDao.save(planEntregaTerrestre);
    }

    @Override
    public void delete(Long id) {
        planEntregaTerrestreDao.deleteById(id);
    }
}
