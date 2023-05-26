package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // anotação para indicar esse tipo de classe
public class TratadorDeErros {
    @ExceptionHandler(EntityNotFoundException.class) // em qualquer controller for lançado uma exception EntityNotFoundException ele sabe que e para chamar esse metodo 404
    public ResponseEntity tratarErro404(){
    return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) //
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors(); // ele vai devolver uma lista contendo cada um dos erros dos campos

        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList()); // body ja devolve o obj ResponseEntity body(erros) ele vai devolver o codigo 400 e a lista no corpo
    }

    private record DadosErroValidacao(String campo, String mensagem){
    public DadosErroValidacao(FieldError erro){
        this(erro.getField(), erro.getDefaultMessage());
        // que da o nome do campo e da a mensagem daquele campo especifico
    }
    }

}
