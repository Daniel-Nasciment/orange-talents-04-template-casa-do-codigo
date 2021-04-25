package com.orange.casa.codigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orange.casa.codigo.Modelo.Estado;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {

}
