package com.nicholassilva.PruebaTecnica.Services;

import com.nicholassilva.PruebaTecnica.models.Dao.IClientesDao;
import com.nicholassilva.PruebaTecnica.models.Entity.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClientesService{
    @Autowired
    private IClientesDao clientesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Clientes> findAll() {
        return (List<Clientes>) clientesDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Clientes> findAll(Pageable pageable) {
        return clientesDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Clientes findById(Long id) {
        return clientesDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Clientes save(Clientes clientes) {
        return clientesDao.save(clientes);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clientesDao.deleteById(id);
    }
}
