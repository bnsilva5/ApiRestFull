package com.nicholassilva.PruebaTecnica.models.Dao;

import com.nicholassilva.PruebaTecnica.models.Entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClientesDao extends JpaRepository<Clientes, Long> {

}
