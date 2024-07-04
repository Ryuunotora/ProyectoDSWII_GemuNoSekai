package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.empleado.service;

import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.empleado.model.Empleado;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoService {

    List<Empleado> listarEmpleado();
    Empleado guardarEmpleado(Empleado empleado);
    Optional<Empleado> obtenerEmpleadoxId(Integer id);


}
