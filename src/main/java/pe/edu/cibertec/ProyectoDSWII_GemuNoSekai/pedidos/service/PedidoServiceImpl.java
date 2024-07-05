package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.model.Cliente;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.repository.ClienteRepository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.empleado.model.Empleado;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.empleado.repository.EmpleadoRepository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.model.Pedido;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.repository.PedidoRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final EmpleadoRepository empleadoRepository;

    @Override
    public List<Pedido> ObtenerPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> ObtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    @Transactional
    public Pedido GuardarPedido(Pedido pedido) {
        Cliente cliente = clienteRepository.findById(pedido.getCliente().getIdCliente())
                .orElseThrow(
                        () -> new RuntimeException("Cliente no encontrado con el id: " + pedido.getCliente().getIdCliente())
                );
        Empleado empleado = empleadoRepository.findById(pedido.getEmpleado().getIdempleado())
                .orElseThrow(
                        () -> new RuntimeException("Empleado no encontrado con el id: " + pedido.getEmpleado().getIdempleado())
                );

        pedido.setCliente(cliente);
        pedido.setEmpleado(empleado);

        return pedidoRepository.save(pedido);
    }

    @Override
    @Transactional
    public Pedido ActualizarPedido(Long id, Pedido pedido) {
        Pedido updatedPedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró pedido con el id: " + id));
        updatedPedido.setFecha(pedido.getFecha());
        updatedPedido.setTotal(pedido.getTotal());

        Cliente cliente = clienteRepository.findById(pedido.getCliente().getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con el id: " + pedido.getCliente().getIdCliente()));
        Empleado empleado = empleadoRepository.findById(pedido.getEmpleado().getIdempleado())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con el id: " + pedido.getEmpleado().getIdempleado()));

        updatedPedido.setCliente(cliente);
        updatedPedido.setEmpleado(empleado);

        return pedidoRepository.save(updatedPedido);
    }
}
