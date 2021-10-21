package com.g30.alquiler.computadores.repositorio;

import java.util.List;
import java.util.Optional;

import com.g30.alquiler.computadores.modelo.Cliente;
import com.g30.alquiler.computadores.repositorio.crud.CrudCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClientes {

    @Autowired
    private CrudCliente metodoscrud;


    public List<Cliente> getTodos(){
        return (List<Cliente>) metodoscrud.findAll();
    }

    public Optional<Cliente> getId(int id){
        return metodoscrud.findById(id);
    }
    public Cliente guardarDato(Cliente cliente){
        return metodoscrud.save(cliente);
    }

    public void eliminar(Cliente cliente){
        metodoscrud.delete(cliente);
    }
}
