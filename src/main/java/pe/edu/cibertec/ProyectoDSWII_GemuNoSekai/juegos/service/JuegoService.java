package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.service;

import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.model.Juego;

import java.util.List;
import java.util.Optional;

public interface JuegoService {
    List<Juego> ObtenerJuegos();
    Optional<Juego>  ObtenerJuego(Long id);
    Juego CrearJuego(Juego juego);
    Juego ActualizarJuego(Long id, Juego juegoUpdated);
}
