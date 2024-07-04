package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.usuario.model.Usuario;


@Repository
public interface UsuarioRepository
    extends JpaRepository<Usuario, Integer> {
    Usuario findByNomusuario(String nomusuario);

}
