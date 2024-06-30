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
    public Optional<Juego> ObtenerJuego(Long id) {
        return juegoRepository.findById(id);
    }

    @Override
    public Juego CrearJuego(Juego juego) {
        return juegoRepository.save(juego);
    }

    @Override
    public Juego ActualizarJuego(Long id, Juego juegoUpdated) {
        Optional<Juego> juegoOptional = juegoRepository.findById(id);
        if (juegoOptional.isPresent()) {
            Juego newJuego = juegoOptional.get();
            newJuego.setNombre(juegoUpdated.getNombre());
            newJuego.setDescripcion(juegoUpdated.getDescripcion());
            newJuego.setPrecio(juegoUpdated.getPrecio());
            newJuego.setStock(juegoUpdated.getStock());
            newJuego.setPlataforma(juegoUpdated.getPlataforma());
            return juegoRepository.save(newJuego);
        }
        else
            return null;
    }
}
