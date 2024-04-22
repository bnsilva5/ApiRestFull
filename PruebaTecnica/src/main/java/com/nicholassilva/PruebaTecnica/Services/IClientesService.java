package com.nicholassilva.PruebaTecnica.Services;

import com.nicholassilva.PruebaTecnica.models.Entity.Clientes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IClientesService {

    public List<Clientes> findAll();
    public Page<Clientes> findAll(Pageable pageable);
    public Clientes findById(Long id);
    public Clientes save(Clientes clientes);
    public void delete(Long id);
}
