package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "juegos")
@Getter
@Setter
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 300)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "plataforma", length = 50)
    private String plataforma;
}
