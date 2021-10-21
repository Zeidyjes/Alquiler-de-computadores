package com.g30.alquiler.computadores.servicio;

import java.util.List;
import java.util.Optional;

import com.g30.alquiler.computadores.modelo.Cliente;
import com.g30.alquiler.computadores.repositorio.RepositorioClientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiCliente {

    @Autowired
    private RepositorioClientes repoCliente;

    public List<Cliente> consultar(){
        return repoCliente.getTodos();
        
    }
    public Optional<Cliente>consultarId(int id){
        return repoCliente.getId(id);

    }

    public Cliente guardar(Cliente client){

        if(client.getIdClient()==null){
            return repoCliente.guardarDato(client);
        }else{
            Optional<Cliente> consulta = repoCliente.getId(client.getIdClient());
            if(consulta.isEmpty()){
                return repoCliente.guardarDato(client);
            }else{
                return client;
            }
        }
        
    }

    public Cliente actualizarCliente(Cliente client){
        if(client.getIdClient()!=null){
            Optional<Cliente> consultar = repoCliente.getId(client.getIdClient());
            if (!consultar.isEmpty()){
                if(client.getName()!=null){
                    consultar.get().setName(client.getName());
                }
                if(client.getEmail()!=null){
                    consultar.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    consultar.get().setPassword(client.getPassword());
                }
                if(client.getAge()!=null){
                    consultar.get().setAge(client.getAge());
                }
                 repoCliente.guardarDato(consultar.get());  
                 return consultar.get();
            }else{
                return client;
            }

        }else{
            return client;
        }    }

        public boolean eliminarCliente(int idCliente){
            Boolean aBoolean =consultarId(idCliente).map(client->{
                repoCliente.eliminar(client);
                return true;
            }).orElse(false);
            return aBoolean;

        }
}
