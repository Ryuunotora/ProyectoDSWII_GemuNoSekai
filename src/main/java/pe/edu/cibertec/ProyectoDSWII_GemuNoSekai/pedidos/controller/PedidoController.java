package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.model.Pedido;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.service.PedidoService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> obtenerPedidos() {
        return ResponseEntity.ok(pedidoService.ObtenerPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pedido>> obtenerPedidoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.ObtenerPedidoPorId(id));
    }

    @PostMapping
    public ResponseEntity<Pedido> guardarPedido(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.GuardarPedido(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        if (!id.equals(pedido.getIdPedido())) {
            return ResponseEntity.badRequest().body("ID mismatch");
        }
        Pedido updatedPedido = pedidoService.ActualizarPedido(id, pedido);
        return ResponseEntity.ok(updatedPedido);
    }
}
