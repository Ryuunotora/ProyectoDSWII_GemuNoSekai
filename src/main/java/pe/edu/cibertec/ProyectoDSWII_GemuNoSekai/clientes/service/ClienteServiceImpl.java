package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.model.Cliente;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService{
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> ObtenerClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> ObtenerCliente(int id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente CrearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente ActualizarCliente(int id, Cliente clienteUpdated) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
            Cliente newCliente = clienteOptional.get();
            newCliente.setNombre(clienteUpdated.getNombre());
            newCliente.setApellido(clienteUpdated.getApellido());
            newCliente.setTelefono(clienteUpdated.getTelefono());
            newCliente.setEmail(clienteUpdated.getEmail());
            return clienteRepository.save(newCliente);


    }
}
