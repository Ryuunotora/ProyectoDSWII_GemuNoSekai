package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.empleado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.empleado.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
