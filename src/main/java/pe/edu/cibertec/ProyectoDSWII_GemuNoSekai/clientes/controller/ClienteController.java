package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.model.Cliente;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.clientes.service.ClienteService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> ListarClientes() {
        List<Cliente> clientes = clienteService.ObtenerClientes();
        if (clientes != null){
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(clientes, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> ListarClientePorId(@PathVariable int id) {
        Optional<Cliente> clienteOptional = clienteService.ObtenerCliente(id);
        if (clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Cliente> CrearCliente(@RequestBody Cliente cliente) {
        Cliente newCliente = clienteService.CrearCliente(cliente);
        if (newCliente != null){
            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cliente> ActualizarCliente(@PathVariable int id, @RequestBody Cliente clienteUpdated) {
        Cliente newCliente = clienteService.ActualizarCliente(id,clienteUpdated);
        if (newCliente != null) {
            return new ResponseEntity<>(newCliente, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(newCliente, HttpStatus.BAD_REQUEST);
        }
    }

}
