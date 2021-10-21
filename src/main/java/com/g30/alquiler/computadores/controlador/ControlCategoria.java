package com.g30.alquiler.computadores.controlador;

import java.util.List;
import java.util.Optional;

import com.g30.alquiler.computadores.modelo.Categoria;
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
import com.g30.alquiler.computadores.servicio.ServiCategoria;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class ControlCategoria {

    @Autowired
    private ServiCategoria serviCategoria;


@GetMapping("/all")
public List<Categoria>getCategorias(){
    return serviCategoria.consultar();
}

@GetMapping("/{id}")
public Optional<Categoria>getCategoria(@PathVariable("id") int idCategoria){
    return serviCategoria.consultarId(idCategoria);
}
@PostMapping("/save")
@ResponseStatus(HttpStatus.CREATED)
public Categoria saveCategoria(@RequestBody Categoria categoria){
    return serviCategoria.guardarCategoria(categoria);
}
@PutMapping("/update")
@ResponseStatus(HttpStatus.CREATED)
public Categoria updateCategoria(@RequestBody Categoria categoria) { 
    return serviCategoria.actualizarCategoria(categoria);
}
@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public boolean delCategori(@PathVariable("id") int idCategoria){
    return serviCategoria.eliminarCategoria(idCategoria);
}


    
}
