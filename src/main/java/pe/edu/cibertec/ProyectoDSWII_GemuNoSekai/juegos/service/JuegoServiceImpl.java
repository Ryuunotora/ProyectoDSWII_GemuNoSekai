package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.model.Juego;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.repository.JuegoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JuegoServiceImpl implements JuegoService{
    private JuegoRepository juegoRepository;

    @Override
    public List<Juego> ObtenerJuegos() {
        return juegoRepository.findAll();
    }

    @Override
    public Optional<Juego> ObtenerJuegoPorId(Long id) {
        return juegoRepository.findById(id);
    }

    @Override
    public Juego GuardarJuego(Juego juego) {
        return juegoRepository.save(juego);
    }

    @Override
    public Juego ActualizarJuego(Long id, Juego juego) {
        Juego updatedJuego = juegoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró juego con el id: " + id));
        updatedJuego.setNombre(juego.getNombre());
        updatedJuego.setDescripcion(juego.getDescripcion());
        updatedJuego.setPrecio(juego.getPrecio());
        updatedJuego.setStock(juego.getStock());
        updatedJuego.setPlataforma(juego.getPlataforma());
        return juegoRepository.save(updatedJuego);
    }
}
