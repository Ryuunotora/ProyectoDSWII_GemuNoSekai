package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.juegos.model.Juego;

@Repository
public interface JuegoRepository extends JpaRepository<Juego,Long> {

}
