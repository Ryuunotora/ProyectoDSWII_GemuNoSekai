package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.model.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

}
