package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.model.Cliente;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.repository.ClienteRepository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.detalle_pedidos.model.DetallePedido;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.empleado.model.Empleado;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.empleado.repository.EmpleadoRepository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.model.Juego;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.repository.JuegoRepository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.model.Pedido;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.repository.PedidoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final EmpleadoRepository empleadoRepository;
    private JuegoRepository juegoRepository;

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
        BigDecimal totalPedido = BigDecimal.ZERO;

        for (DetallePedido detalle : pedido.getDetallesPedidos()) {
            Juego juego = juegoRepository.findById(detalle.getJuego().getIdjuego())
                    .orElseThrow(
                            () -> new RuntimeException("Juego no encontrado con el id: " + detalle.getJuego().getIdjuego())
                    );

            detalle.setPrecio(new BigDecimal(String.valueOf(juego.getPrecio())));
            BigDecimal subtotal = detalle.getPrecio().multiply(new BigDecimal(detalle.getCantidad()));
            totalPedido = totalPedido.add(subtotal);
            detalle.setPedido(pedido);
        }

        pedido.setTotal(totalPedido);
        LocalDate fecha = LocalDate.now();
        pedido.setFecha(fecha);
        return pedidoRepository.save(pedido);
    }



}
