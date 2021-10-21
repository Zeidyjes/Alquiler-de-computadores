package com.g30.alquiler.computadores.repositorio.crud;

import com.g30.alquiler.computadores.modelo.Computador;

import org.springframework.data.repository.CrudRepository;

public interface CrudComputadores extends CrudRepository<Computador,Integer>{
    
}
