package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.detalle_pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.detalle_pedidos.model.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}