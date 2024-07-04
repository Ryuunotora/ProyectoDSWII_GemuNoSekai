package pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import pe.edu.cibertec.ProyectoDSWII_GemuNoSekai.exception.dto.MensajeErrorDto;


import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public MensajeErrorDto handleIllegalArgumentException(
            IllegalArgumentException ex,
            WebRequest request
    ) {
        return MensajeErrorDto.builder()
                .mensaje(ex.getMessage())
                .codigoEstado(HttpStatus.BAD_REQUEST.value())
                .fechaError(new Date())
                .descripcion(request.getDescription(true)).build();
    }
}
