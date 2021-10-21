package com.g30.alquiler.computadores.servicio;

import java.util.List;
import java.util.Optional;

import com.g30.alquiler.computadores.modelo.Categoria;
import com.g30.alquiler.computadores.repositorio.RepositorioCategorias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiCategoria {
    

    @Autowired
    private RepositorioCategorias repoCategorias;


    public List<Categoria> consultar(){
        return repoCategorias.getTodos();
    }

    public Optional<Categoria> consultarId(int idCategoria){
        return repoCategorias.getId(idCategoria);
    }

    public Categoria guardarCategoria(Categoria cate){
        if(cate.getId()==null){
            return repoCategorias.guardar(cate);
        }else{
            Optional<Categoria> consulta =repoCategorias.getId(cate.getId());
            if(consulta.isEmpty()){
                return repoCategorias.guardar(cate);
            }else{
                return cate;
            }
        }
    }
    public Categoria actualizarCategoria(Categoria cate){
        if(cate.getId()!=null){
            Optional<Categoria> consulta=repoCategorias.getId(cate.getId());
            if(!consulta.isEmpty()){
                if(cate.getDescription()!=null){
                    consulta.get().setDescription(cate.getDescription());
                }
                if(cate.getId()!=null){
                    consulta.get().setId(cate.getId());
                }
                if(cate.getName()!=null){
                    consulta.get().setName(cate.getName());
                }
                repoCategorias.guardar(consulta.get());
                return consulta.get();
            }else{
                return cate;
            }
        }else{
            return cate;
        }
    }


    public boolean eliminarCategoria(int idCategoria){
        Boolean aBoolean =consultarId(idCategoria).map(cate->{
            repoCategorias.eliminar(cate);
            return true;
        }).orElse(false);
        return aBoolean;

    }
}
