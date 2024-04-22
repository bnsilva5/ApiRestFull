package com.nicholassilva.PruebaTecnica.models.Dao;

import com.nicholassilva.PruebaTecnica.models.Entity.Envios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnviosDao extends JpaRepository<Envios, Long> {
}
