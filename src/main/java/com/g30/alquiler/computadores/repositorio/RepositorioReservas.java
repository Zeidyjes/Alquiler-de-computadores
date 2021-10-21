package com.g30.alquiler.computadores.repositorio;

import java.util.List;
import java.util.Optional;

import com.g30.alquiler.computadores.modelo.Reservaciones;
import com.g30.alquiler.computadores.repositorio.crud.CrudReservas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservas{

    @Autowired
    private CrudReservas metodoscrud;


    public List<Reservaciones> getTodos(){
        return (List<Reservaciones>) metodoscrud.findAll();
    }

    public Optional<Reservaciones> getId(int id){
        return metodoscrud.findById(id);
    }
    public Reservaciones guardarDato(Reservaciones reserva){
        return metodoscrud.save(reserva);
    }

    public void eliminar(Reservaciones reserva){
        metodoscrud.delete(reserva);
    }
}