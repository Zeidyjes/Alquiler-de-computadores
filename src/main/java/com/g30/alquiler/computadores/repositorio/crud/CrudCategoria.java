package com.g30.alquiler.computadores.repositorio.crud;

import com.g30.alquiler.computadores.modelo.Categoria;

import org.springframework.data.repository.CrudRepository;

public interface CrudCategoria extends CrudRepository<Categoria,Integer> {
    
}
