package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}
