package com.g30.alquiler.computadores.repositorio.crud;

import com.g30.alquiler.computadores.modelo.Mensaje;

import org.springframework.data.repository.CrudRepository;

public interface CrudMesajes extends CrudRepository<Mensaje,Integer> {
    
}
