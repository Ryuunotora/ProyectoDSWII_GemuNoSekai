package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.model.Pedido;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.pedidos.service.PedidoService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/pedidos")
public class PedidoController {
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> ObtenerPedidos(){
        List<Pedido>pedidos= pedidoService.ObtenerPedidos();
        if (pedidos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pedidos,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> ObtenerPedidoPorId(@PathVariable Long id){
        Pedido pedido = pedidoService.ObtenerPedidoPorId(id).orElseThrow(
                () -> new RuntimeException("No se encontró pedido con id: ")
        );
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pedido> GuardarPedido(@RequestBody Pedido pedido){
        Pedido newPedido = pedidoService.GuardarPedido(pedido);
        return new ResponseEntity<>(newPedido, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> ActualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido){
        Pedido updatedPedido = pedidoService.ActualizarPedido(id,pedido);
        if (updatedPedido == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updatedPedido, HttpStatus.OK);
    }

}
