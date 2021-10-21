package com.g30.alquiler.computadores.repositorio.crud;

import com.g30.alquiler.computadores.modelo.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface CrudCliente extends CrudRepository<Cliente,Integer>{
    
}
