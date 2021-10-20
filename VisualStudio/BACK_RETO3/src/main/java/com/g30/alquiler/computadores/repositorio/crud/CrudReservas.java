package com.g30.alquiler.computadores.repositorio.crud;
import com.g30.alquiler.computadores.modelo.Reservaciones;

import org.springframework.data.repository.CrudRepository;

public interface CrudReservas extends CrudRepository<Reservaciones,Integer>  {
    
}
