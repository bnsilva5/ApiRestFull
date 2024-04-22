package com.nicholassilva.PruebaTecnica.Services;

import com.nicholassilva.PruebaTecnica.models.Entity.Envios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IEnviosService {
    public List<Envios> findAll();
    public Page<Envios> findAll(Pageable pageable);
    public Envios findById(Long id);
    public Envios save(Envios envios);
    public void delete(Long id);
}
