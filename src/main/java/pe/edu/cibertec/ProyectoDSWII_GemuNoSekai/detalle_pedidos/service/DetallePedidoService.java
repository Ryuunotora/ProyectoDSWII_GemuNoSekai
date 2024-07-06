package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.detalle_pedidos.service;

import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.detalle_pedidos.model.DetallePedido;

import java.util.List;
import java.util.Optional;

public interface DetallePedidoService {
    List<DetallePedido> obtenerDetallesPedidos();
    Optional<DetallePedido> obtenerDetallePedidoPorId(Long id);
    DetallePedido guardarDetallePedido(DetallePedido detallePedido);
    DetallePedido actualizarDetallePedido(Long id, DetallePedido detallePedido);
}