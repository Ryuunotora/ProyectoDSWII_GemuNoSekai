package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.usuario.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.usuario.model.Usuario;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.usuario.repository.UsuarioRepository;


@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario obtenerUsuarioPorNomUsuario(
            String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }
}
