package com.g30.alquiler.computadores.repositorio;

import java.util.List;
import java.util.Optional;

import com.g30.alquiler.computadores.modelo.Categoria;
import com.g30.alquiler.computadores.repositorio.crud.CrudCategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCategorias {

    @Autowired
    private CrudCategoria crudCategorias;


    public List<Categoria> getTodos(){
        return (List<Categoria>) crudCategorias.findAll(); 
    }
    
    public Optional<Categoria> getId(int id){
        return crudCategorias.findById(id);
    }

    public Categoria guardar(Categoria Cate){
        return crudCategorias.save(Cate);

    }

    public void eliminar(Categoria Cate){
        crudCategorias.delete(Cate);
    }
}