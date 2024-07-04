package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.usuario.service;


import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.usuario.model.Usuario;

public interface IUsuarioService {

    Usuario obtenerUsuarioPorNomUsuario(
            String nomusuario);
}
