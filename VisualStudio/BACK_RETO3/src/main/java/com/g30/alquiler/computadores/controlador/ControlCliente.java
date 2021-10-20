package com.g30.alquiler.computadores.controlador;

import java.util.List;
import java.util.Optional;

import com.g30.alquiler.computadores.modelo.Cliente;
import com.g30.alquiler.computadores.servicio.ServiCliente;

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
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControlCliente {

    @Autowired
    private ServiCliente serviCliente;

    @GetMapping("/all")
    public List<Cliente>getClientes(){
        return serviCliente.consultar();
    }

    @GetMapping("/{id}")
    public Optional<Cliente>getCliente(@PathVariable("id") int idCliente){
            return serviCliente.consultarId(idCliente);
        };

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente saveCliente(@RequestBody Cliente cliente){
        return serviCliente.guardar(cliente);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente updateCliente(@RequestBody Cliente cliente){
        return serviCliente.actualizarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminarCliente(@PathVariable("id")int idCliente){
        return serviCliente.eliminarCliente(idCliente);
    }
    }
    
