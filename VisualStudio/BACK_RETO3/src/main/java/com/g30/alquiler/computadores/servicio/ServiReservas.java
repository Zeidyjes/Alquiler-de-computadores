package com.g30.alquiler.computadores.servicio;

import java.util.List;
import java.util.Optional;

import com.g30.alquiler.computadores.modelo.Reservaciones;
import com.g30.alquiler.computadores.repositorio.RepositorioReservas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiReservas {

 @Autowired
 private RepositorioReservas repositorioReservas;

    public List<Reservaciones> getReservas(){
        return repositorioReservas.getTodos();
    }
    
    public Optional<Reservaciones> getIdReserva(int id){
        return repositorioReservas.getId(id);
    }

    public Reservaciones guardarReserva(Reservaciones reser){
        if(reser.getIdReservation()==null){
            return repositorioReservas.guardarDato(reser);
        }else{
            Optional<Reservaciones> consulta = repositorioReservas.getId(reser.getIdReservation());
            if(consulta.isEmpty()){
                return repositorioReservas.guardarDato(reser);
            }else{
                return reser;
            }
        }
    }

    public Reservaciones actualizarReserva(Reservaciones reser){
        if(reser.getIdReservation()!=null){
            Optional<Reservaciones> consulta = repositorioReservas.getId(reser.getIdReservation());

            if(!consulta.isEmpty()){
                if(reser.getDevolutionDate()!=null){
                    consulta.get().setDevolutionDate(reser.getDevolutionDate());
                }
                if(reser.getStartDate()!=null){
                    consulta.get().setStartDate(reser.getStartDate());
                     }
                if(reser.getStatus()!=null){
                    consulta.get().setStatus(reser.getStatus());
                }
                     repositorioReservas.guardarDato(consulta.get());
                     return consulta.get();
            }else{
                return reser;}

        }else{
            return reser;
        }
        }
        public boolean eliminarReserva(int idReser){
            Boolean aBoolean = getIdReserva(idReser).map(reserva->{
              repositorioReservas.eliminar(reserva);
                  return true;
              }).orElse(false);
              return aBoolean;
      
          }
}
