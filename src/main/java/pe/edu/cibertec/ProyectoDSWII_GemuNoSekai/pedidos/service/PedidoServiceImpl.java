package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.model.Cliente;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.repository.ClienteRepository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.model.Pedido;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.repository.PedidoRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService{
    private PedidoRepository pedidoRepository;
    private ClienteRepository clienteRepository;

    public List<Pedido> ObtenerPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> ObtenerPedidoPorId(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isEmpty()){
            return Optional.empty();
        }
        return pedido;
    }

    public Pedido GuardarPedido(Pedido pedido) {
        Cliente cliente = clienteRepository.findById(pedido.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con el id: " + pedido.getCliente().getId()));
        pedido.setCliente(cliente);
        return pedidoRepository.save(pedido);
    }

    public Pedido ActualizarPedido(Long id, Pedido pedido) {
        Pedido updatedPedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró pedido con el id: " + id));
        updatedPedido.setFecha(pedido.getFecha());
        updatedPedido.setTotal(pedido.getTotal());
        return pedidoRepository.save(pedido);
    }

}
