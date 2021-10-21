package com.g30.alquiler.computadores.controlador;

import java.util.List;
import java.util.Optional;

import com.g30.alquiler.computadores.modelo.Mensaje;
import com.g30.alquiler.computadores.servicio.ServiMensaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST})
public class ControlMensajes {

    @Autowired
    private ServiMensaje serviMensaje;


    @GetMapping("/all")
    public List<Mensaje> getMensajes(){
        return serviMensaje.consultar();
    }
    
    @GetMapping("/{id}")
    public Optional<Mensaje>getMensaje(@PathVariable("id") int idMensaje){
        return serviMensaje.consultarId(idMensaje);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje guardarMensajes(@RequestBody Mensaje mensajes){
        return serviMensaje.guardarMensaje(mensajes);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje updateMensaje(@RequestBody Mensaje mensajes){
        return serviMensaje.actualizarMensaje(mensajes);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delMensaje(@PathVariable("id") int idMensaje){
        return serviMensaje.eliminarMensaje(idMensaje);
    }

}
