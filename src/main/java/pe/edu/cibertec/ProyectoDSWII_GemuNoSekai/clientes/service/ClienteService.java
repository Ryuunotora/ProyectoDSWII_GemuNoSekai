package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.service;

import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> ObtenerClientes();
    Optional<Cliente> ObtenerCliente(int id);
    Cliente CrearCliente(Cliente cliente);
    Cliente ActualizarCliente(int id, Cliente cliente);
    
}
