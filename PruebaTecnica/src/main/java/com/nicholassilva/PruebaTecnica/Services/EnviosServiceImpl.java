package com.nicholassilva.PruebaTecnica.Services;

import com.nicholassilva.PruebaTecnica.models.Dao.IEnviosDao;
import com.nicholassilva.PruebaTecnica.models.Entity.Envios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnviosServiceImpl implements IEnviosService{

    @Autowired
    private IEnviosDao enviosDao;
    @Override
    @Transactional(readOnly = true)
    public List<Envios> findAll() {
        return (List<Envios>) enviosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Envios> findAll(Pageable pageable) {
        return enviosDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Envios findById(Long id) {
        return enviosDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Envios save(Envios envios) {
        return enviosDao.save(envios);
    }

    @Override
    public void delete(Long id) {
        enviosDao.deleteById(id);
    }
}
