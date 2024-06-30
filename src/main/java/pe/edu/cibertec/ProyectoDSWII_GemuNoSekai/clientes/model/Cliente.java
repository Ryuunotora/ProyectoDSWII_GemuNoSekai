package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    @Column(name = "telefono", length = 15)
    private String telefono;

}
