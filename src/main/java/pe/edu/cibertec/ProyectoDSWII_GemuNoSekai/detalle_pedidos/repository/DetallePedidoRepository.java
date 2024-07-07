package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.detalle_pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.detalle_pedidos.model.DetallePedido;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.model.Juego;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.model.Pedido;

import java.util.List;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}