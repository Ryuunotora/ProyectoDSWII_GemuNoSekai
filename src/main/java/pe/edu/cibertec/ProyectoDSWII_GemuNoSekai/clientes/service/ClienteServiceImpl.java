package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.model.Cliente;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.repository.ClienteRepository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.model.Pedido;

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
    public Optional<Cliente> ObtenerClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (!cliente.isPresent()){
            return Optional.empty();
        }
        return cliente;
    }

    @Override
    public Cliente GuardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente ActualizarCliente(Long id, Cliente cliente) {
        Cliente updatedCliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró cliente con el id: " + id));
        updatedCliente.setNombre(cliente.getNombre());
        updatedCliente.setApellido(cliente.getApellido());
        updatedCliente.setEmail(cliente.getEmail());
        updatedCliente.setTelefono(cliente.getTelefono());
        return clienteRepository.save(updatedCliente);
    }
}
