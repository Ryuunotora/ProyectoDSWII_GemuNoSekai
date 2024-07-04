package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.empleado.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idempleado;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "puesto")
    private String puesto;
    @Column(name = "fecha_contratacion")
    private Date fecha_contratacion;
    @Column(name = "salario")
    private Double salario;
    @Column(name = "activo")
    private Boolean activo;

}
