package com.g30.alquiler.computadores.repositorio;

import java.util.List;
import java.util.Optional;

import com.g30.alquiler.computadores.modelo.Mensaje;
import com.g30.alquiler.computadores.repositorio.crud.CrudMesajes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMensajes {

    @Autowired
    private CrudMesajes crudMensajes;


    public List<Mensaje> getTodosMsj(){
        return (List<Mensaje>) crudMensajes.findAll(); 
    }
    
    public Optional<Mensaje> getIdMjs(int idMensaje){
        return crudMensajes.findById(idMensaje);
    }

    public Mensaje guardar(Mensaje msj){
        return crudMensajes.save(msj);

    }

    public void eliminar(Mensaje msj){
        crudMensajes.delete(msj);
    }
}
