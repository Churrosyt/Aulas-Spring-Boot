package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // anotação para indicar esse tipo de classe
public class TratadorDeErros {
    @ExceptionHandler(EntityNotFoundException.class) // em qualquer controller for lançado uma exception EntityNotFoundException ele sabe que e para chamar esse metodo 404
    public ResponseEntity tratarErro404(){
    return ResponseEntity.notFound().build();
    }

}
