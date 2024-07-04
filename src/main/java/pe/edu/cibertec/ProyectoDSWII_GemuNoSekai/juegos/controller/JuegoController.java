package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.model.Juego;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.service.JuegoService;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.service.JuegoServiceImpl;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/juegos")
public class JuegoController {
    private JuegoService juegoService;

    @GetMapping
    public ResponseEntity<List<Juego>> ObtenerJuegos() {
        List<Juego> juegos = juegoService.ObtenerJuegos();
        if (juegos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(juegos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Juego> ObtenerJuegoPorId(@PathVariable Long id) {
        Juego juego = juegoService.ObtenerJuegoPorId(id)
                .orElseThrow(() -> new RuntimeException("No se encontró juego con id: " + id));
        return new ResponseEntity<>(juego, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Juego> GuardarJuego(@RequestBody Juego juego) {
        Juego newJuego = juegoService.GuardarJuego(juego);
        return new ResponseEntity<>(newJuego, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Juego> ActualizarJuego(@PathVariable Long id, @RequestBody Juego juego) {
        Juego updatedJuego = juegoService.ActualizarJuego(id, juego);
        return new ResponseEntity<>(updatedJuego, HttpStatus.ACCEPTED);
    }
}
