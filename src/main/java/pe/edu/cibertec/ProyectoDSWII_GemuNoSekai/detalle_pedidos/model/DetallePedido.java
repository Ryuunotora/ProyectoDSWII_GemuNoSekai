package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.detalle_pedidos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.model.Juego;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.model.Pedido;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detalle_pedidos")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetalle")
    private Long idDetalle;

    @ManyToOne(targetEntity = Pedido.class)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne(targetEntity = Juego.class)
    @JoinColumn(name = "juego_id")
    private Juego juego;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio", precision = 10, scale = 2, nullable = false)
    private BigDecimal precio;

    @Column(name = "precio_total", precision = 10, scale = 2, nullable = false)
    private BigDecimal precioTotal;
}