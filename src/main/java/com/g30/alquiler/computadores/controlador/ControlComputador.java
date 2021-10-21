package com.g30.alquiler.computadores.controlador;

import java.util.List;
import java.util.Optional;
import com.g30.alquiler.computadores.modelo.Computador;
import com.g30.alquiler.computadores.servicio.ServiComputador;

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
@RequestMapping("/api/Computer")
@CrossOrigin(origins = "*",methods ={RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.GET})
public class ControlComputador {
    
    @Autowired
    private ServiComputador serviComputador;


    @GetMapping("/all")
    public List<Computador>getComputadores(){
        return serviComputador.consultar();
    }

    @GetMapping(value="/{id}")
    public Optional<Computador> getComputador(@PathVariable("id") int idComputador) {
        return serviComputador.consultarId(idComputador);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Computador guardarComputador(@RequestBody Computador computador){
        return serviComputador.guardarComputador(computador);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Computador updateComputador(@RequestBody Computador computador){
        return serviComputador.actualizarComputador(computador);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrarComputador(@PathVariable("id") int idComputador){
        return serviComputador.eliminarComputador(idComputador);
    }}
