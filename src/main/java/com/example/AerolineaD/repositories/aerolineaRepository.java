package com.example.AerolineaD.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example.AerolineaD.models.aerolineaMo;

public interface aerolineaRepository extends CrudRepository<aerolineaMo, Long> {
    List<aerolineaMo> findByPrioridad(Integer prioridad);
}
