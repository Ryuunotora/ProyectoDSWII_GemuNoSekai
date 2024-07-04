package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.service;

import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.model.Juego;

import java.util.List;
import java.util.Optional;

public interface JuegoService {
    List<Juego> ObtenerJuegos();
    Optional<Juego> ObtenerJuegoPorId(Long id);
    Juego GuardarJuego(Juego juego);
    Juego ActualizarJuego(Long id, Juego juego);
}
