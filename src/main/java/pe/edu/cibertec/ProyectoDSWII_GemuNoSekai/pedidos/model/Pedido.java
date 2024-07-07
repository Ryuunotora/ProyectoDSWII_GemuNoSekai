package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.model.Cliente;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.detalle_pedidos.model.DetallePedido;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.empleado.model.Empleado;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.model.Juego;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpedido")
    private Long idPedido;
    @Column(name = "fecha", columnDefinition = "DATE")
    private LocalDate fecha;
    @Column(name = "total", precision = 10, scale = 2, nullable = false)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    @OneToMany(targetEntity= DetallePedido.class, mappedBy = "pedido", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<DetallePedido> detallesPedidos;

}