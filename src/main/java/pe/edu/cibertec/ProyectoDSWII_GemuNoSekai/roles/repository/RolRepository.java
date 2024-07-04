package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.roles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.roles.model.Rol;


@Repository
public interface RolRepository extends
        JpaRepository<Rol, Integer> {

    Rol findByNomrol(String nomrol);
}
