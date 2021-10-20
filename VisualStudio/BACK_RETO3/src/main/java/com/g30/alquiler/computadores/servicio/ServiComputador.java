package com.g30.alquiler.computadores.servicio;

import java.util.List;
import java.util.Optional;

import com.g30.alquiler.computadores.modelo.Computador;
import com.g30.alquiler.computadores.repositorio.RepositorioComputadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiComputador {
    
    @Autowired
    private RepositorioComputadores repoComputadores;


    public List<Computador> consultar(){
        return repoComputadores.getTodos();
    }

    public Optional<Computador> consultarId(int idCompu){
        return repoComputadores.getId(idCompu);
    }

    public Computador guardarComputador(Computador compu){
        if(compu.getId()==null){
            return repoComputadores.guardarDato(compu);
        }else{
            Optional<Computador> consulta =repoComputadores.getId(compu.getId());
            if(consulta.isEmpty()){
                return repoComputadores.guardarDato(compu);
            }else{
                return compu;
            }
        }
    }
    public Computador actualizarComputador(Computador compu){
        if(compu.getId()!=null){
            Optional<Computador> consulta=repoComputadores.getId(compu.getId());
            if(!consulta.isEmpty()){
                if(compu.getDescription()!=null){
                    consulta.get().setDescription(compu.getDescription());
                }
                if(compu.getName()!=null){
                    consulta.get().setName(compu.getName());
                }
                if(compu.getYear()!=null){
                    consulta.get().setYear(compu.getYear());
                }
                if(compu.getBrand()!=null){
                    consulta.get().setBrand(compu.getBrand());
                }
                repoComputadores.guardarDato(consulta.get());
                return consulta.get();
            }else{
                return compu;
            }
        }else{
            return compu;
        }
    }
    public boolean eliminarComputador(int idCompu){
        Boolean aBoolean =consultarId(idCompu).map(compu->{
            repoComputadores.eliminar(compu);
            return true;
        }).orElse(false);
        return aBoolean;

    }
}
