package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.detalle_pedidos.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.detalle_pedidos.model.DetallePedido;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.detalle_pedidos.service.DetallePedidoService;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.model.Pedido;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/detalle_pedidos")
public class DetallePedidoController {
    private final DetallePedidoService detallePedidoService;

    public DetallePedidoController(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }

    @GetMapping
    public List<DetallePedido> obtenerDetallesPedidos() {
        return detallePedidoService.obtenerDetallesPedidos();
    }

    @GetMapping("/{id}")
    public Optional<DetallePedido> obtenerDetallePedidoPorId(@PathVariable Long id) {
        return detallePedidoService.obtenerDetallePedidoPorId(id);
    }

    @PostMapping
    public ResponseEntity<DetallePedido>guardarDetallePedido(@RequestBody DetallePedido detallePedido) {
        return ResponseEntity.ok(detallePedidoService.guardarDetallePedido(detallePedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarDetallePedido(@PathVariable Long id, @RequestBody DetallePedido detallePedido) {
        if (!id.equals(detallePedido.getIdDetalle())) {
            return ResponseEntity.badRequest().body("ID mismatch");
        }
        DetallePedido updatedDetallePedido = detallePedidoService.actualizarDetallePedido(id, detallePedido);
        return ResponseEntity.ok(updatedDetallePedido);

    }
}