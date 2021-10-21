package com.g30.alquiler.computadores.repositorio;

import java.util.List;
import java.util.Optional;
import com.g30.alquiler.computadores.modelo.Computador;
import com.g30.alquiler.computadores.repositorio.crud.CrudComputadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioComputadores {

    @Autowired
    private CrudComputadores metodoscrud;


    public List<Computador> getTodos(){
        return (List<Computador>) metodoscrud.findAll();
    }

    public Optional<Computador> getId(int id){
        return metodoscrud.findById(id);
    }
    public Computador guardarDato(Computador compu){
        return metodoscrud.save(compu);
    }

    public void eliminar(Computador compu){
        metodoscrud.delete(compu);
    }
}
