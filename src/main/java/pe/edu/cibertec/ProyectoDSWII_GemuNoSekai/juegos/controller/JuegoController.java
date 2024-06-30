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
@RequestMapping("api/v1/juego")
public class JuegoController {
    private JuegoService juegoService;

    @GetMapping
    public ResponseEntity<List<Juego>> ListarJuegos(){
        List<Juego> juegos = juegoService.ObtenerJuegos();
        if (!juegos.isEmpty()){
            return new ResponseEntity<>(juegos, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(juegos, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Juego> ObtenerJuegoPorId(@PathVariable Long id){
        Juego juego = juegoService.ObtenerJuego(id).get();
        return new ResponseEntity<>(juego, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Juego> CrearJuego(@RequestBody Juego juego){
        Juego newJuego = juegoService.CrearJuego(juego);
        if (newJuego != null){
            return new ResponseEntity<>(newJuego,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(newJuego,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Juego> ActualizarJuego(@PathVariable Long id, @RequestBody Juego newJuego){
        Juego juegoUpdated = juegoService.ActualizarJuego(id, newJuego);
            if (juegoUpdated != null){
                return new ResponseEntity<>(juegoUpdated,HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(juegoUpdated,HttpStatus.BAD_REQUEST);
            }
    }

}
