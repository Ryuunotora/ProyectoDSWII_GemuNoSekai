package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.service;

import org.springframework.security.core.parameters.P;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.model.Juego;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> ObtenerPedidos();
    Optional<Pedido> ObtenerPedidoPorId(Long id);
    Pedido GuardarPedido(Pedido pedido);

}
