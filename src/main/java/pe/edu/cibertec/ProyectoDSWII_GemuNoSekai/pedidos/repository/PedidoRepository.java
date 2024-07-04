package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
