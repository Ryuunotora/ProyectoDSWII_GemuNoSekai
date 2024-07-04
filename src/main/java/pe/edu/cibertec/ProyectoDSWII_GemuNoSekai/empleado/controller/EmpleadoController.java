package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.empleado.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.empleado.model.Empleado;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.empleado.service.EmpleadoService;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/empleado")
public class EmpleadoController {

    private EmpleadoService empleadoService;

    @GetMapping("")
    public ResponseEntity<List<Empleado>> listarEmpleados(){
        List<Empleado> alumnoList =
                new ArrayList<>(empleadoService.listarEmpleado());
        if(alumnoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alumnoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoXId(
            @PathVariable Integer id){
        Empleado empleado = empleadoService
                .obtenerEmpleadoxId(id).orElseThrow(
                        () -> new ResourceNotFoundException("El Empleado con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Empleado> registrarEmpleado(
            @RequestBody Empleado empleado
    ){
        return new ResponseEntity<>(
                empleadoService.guardarEmpleado(empleado), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarAlumno(
            @PathVariable Integer id,
            @RequestBody Empleado empleado
    ){
        Empleado newEmpleado = empleadoService.obtenerEmpleadoxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Empleado con Id "
                        + id +" no existe"));
        newEmpleado.setNombre(empleado.getNombre());
        newEmpleado.setApellido(empleado.getApellido());
        newEmpleado.setEmail(empleado.getEmail());
        newEmpleado.setTelefono(empleado.getTelefono());
        newEmpleado.setPuesto(empleado.getPuesto());
        newEmpleado.setFecha_contratacion(empleado.getFecha_contratacion());
        newEmpleado.setSalario(empleado.getSalario());
        newEmpleado.setActivo(empleado.getActivo());

        return new ResponseEntity<>(
                empleadoService.guardarEmpleado(newEmpleado),
                HttpStatus.OK);
    }

}
