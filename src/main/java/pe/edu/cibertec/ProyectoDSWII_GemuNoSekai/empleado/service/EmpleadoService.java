package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.empleado.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.empleado.model.Empleado;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.empleado.repository.EmpleadoRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmpleadoService implements IEmpleadoService{

    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> listarEmpleado() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Optional<Empleado> obtenerEmpleadoxId(Integer id) {
        Optional<Empleado> empleado
                = empleadoRepository.findById(id);
        if(empleado.isEmpty()){
            return Optional.empty();
        }
        return empleado;
    }
}
