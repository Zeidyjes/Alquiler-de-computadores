package com.g30.alquiler.computadores.servicio;

import java.util.List;
import java.util.Optional;

import com.g30.alquiler.computadores.modelo.Mensaje;
import com.g30.alquiler.computadores.repositorio.RepositorioMensajes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiMensaje {
    
    @Autowired
    private RepositorioMensajes repoMensajes;


    public List<Mensaje> consultar(){
        return repoMensajes.getTodosMsj();
    }

    public Optional<Mensaje> consultarId(int idMensaje){
        return repoMensajes.getIdMjs(idMensaje);
    }

    public Mensaje guardarMensaje(Mensaje mensaje){
        if(mensaje.getIdMessage()==null){
            return repoMensajes.guardar(mensaje);
        }else{
            Optional<Mensaje> consulta =repoMensajes.getIdMjs(mensaje.getIdMessage());
            if(consulta.isEmpty()){
                return repoMensajes.guardar(mensaje);
            }else{
                return mensaje;
            }
        }
    }
    public Mensaje actualizarMensaje(Mensaje mensaje){
        if(mensaje.getIdMessage()!=null){
            Optional<Mensaje> consulta=repoMensajes.getIdMjs(mensaje.getIdMessage());
            if(!consulta.isEmpty()){
                if(mensaje.getMessageText()!=null){
                    consulta.get().setMessageText(mensaje.getMessageText());
                }
                repoMensajes.guardar(consulta.get());
                return consulta.get();
            }else{
                return mensaje;
            }
        }else{
            return mensaje;
        }
    }
    public boolean eliminarMensaje(int idMsj){
      Boolean aBoolean = consultarId(idMsj).map(mensaje->{
          repoMensajes.eliminar(mensaje);
            return true;
        }).orElse(false);
        return aBoolean;

    }
}