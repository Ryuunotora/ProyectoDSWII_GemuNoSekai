package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.detalle_pedidos.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.detalle_pedidos.model.DetallePedido;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.detalle_pedidos.repository.DetallePedidoRepository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.model.Juego;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.repository.JuegoRepository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.model.Pedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {
    private final DetallePedidoRepository detallePedidoRepository;


    public DetallePedidoServiceImpl(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @Override
    public List<DetallePedido> obtenerDetallesPedidos() {
        return detallePedidoRepository.findAll();
    }

    @Override
    public Optional<DetallePedido> obtenerDetallePedidoPorId(Long id) {
        return detallePedidoRepository.findById(id);
    }

    @Override
    @Transactional
    public DetallePedido guardarDetallePedido(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    @Override
    @Transactional
    public DetallePedido actualizarDetallePedido(Long id, DetallePedido detallePedido) {
        DetallePedido updatedDetallePedido = detallePedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró detalle de pedido con el id: " + id));
        updatedDetallePedido.setCantidad(detallePedido.getCantidad());
        updatedDetallePedido.setJuego(detallePedido.getJuego());
        updatedDetallePedido.setPedido(detallePedido.getPedido());
        updatedDetallePedido.setPrecio(detallePedido.getPrecio());
        /*updatedDetallePedido.setPrecioTotal(detallePedido.getPrecioTotal());*/
        return detallePedidoRepository.save(updatedDetallePedido);
    }

}