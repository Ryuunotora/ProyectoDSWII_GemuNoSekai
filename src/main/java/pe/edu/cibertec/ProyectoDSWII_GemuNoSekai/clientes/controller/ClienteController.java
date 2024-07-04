package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.model.Cliente;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.service.ClienteService;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {
    private ClienteService clienteService;

        @GetMapping
        public ResponseEntity<List<Cliente>> ObtenerClientes() {
            List<Cliente> clientes = clienteService.ObtenerClientes();
            if (clientes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Cliente> ObtenerClientePorId(@PathVariable Long id) {
            Cliente cliente = clienteService.ObtenerClientePorId(id)
                    .orElseThrow(() -> new RuntimeException("No se encontró cliente con id: " + id));
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<Cliente> GuardarCliente(@RequestBody Cliente cliente) {
            Cliente newCliente = clienteService.GuardarCliente(cliente);
            return new ResponseEntity<>(newCliente, HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Cliente> ActualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
            Cliente updatedCliente = clienteService.ActualizarCliente(id, cliente);
            return new ResponseEntity<>(updatedCliente, HttpStatus.ACCEPTED);
        }

}

