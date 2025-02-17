package br.com.arquitec.exceptions.handler;

import br.com.arquitec.exceptions.AccountNotActivatedException;
import br.com.arquitec.exceptions.InvalidEmailException;
import br.com.arquitec.exceptions.InvalidJwtTokenException;
import br.com.arquitec.exceptions.WrongCredentialsException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({InvalidEmailException.class})
    public ResponseEntity<Map<String, String>> invalidEmailException(InvalidEmailException e) {
        e.printStackTrace();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(responseBuilder(e.getMessage(), httpStatus.value()), httpStatus);
    }

    @ExceptionHandler({EntityExistsException.class})
    public ResponseEntity<Map<String, String>> entityExistsException(EntityExistsException e) {
        e.printStackTrace();
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        return new ResponseEntity<>(responseBuilder(e.getMessage(), httpStatus.value()), httpStatus);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Map<String, String>> entityNotFoundException(EntityNotFoundException e) {
        e.printStackTrace();
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseBuilder(e.getMessage(), httpStatus.value()), httpStatus);
    }

    @ExceptionHandler({AccountNotActivatedException.class})
    public ResponseEntity<Map<String, String>> accountNotActivatedException(AccountNotActivatedException e) {
        e.printStackTrace();
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        return new ResponseEntity<>(responseBuilder(e.getMessage(), httpStatus.value()), httpStatus);
    }

    @ExceptionHandler({WrongCredentialsException.class})
    public ResponseEntity<Map<String, String>> wrongCredentialsException(WrongCredentialsException e) {
        e.printStackTrace();
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseBuilder(e.getMessage(), httpStatus.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InvalidJwtTokenException.class})
    public ResponseEntity<Map<String, String>> invalidJwtTokenException(InvalidJwtTokenException e) {
        e.printStackTrace();
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseBuilder(e.getMessage(), httpStatus.value()), httpStatus);
    }

    private Map<String, String> responseBuilder(String exceptionMessage, int statusValue) {
        Map<String, String> response = new HashMap<>();
        response.put("message", exceptionMessage);
        response.put("time", LocalDateTime.now().toString());
        response.put("status", String.valueOf(statusValue));

        return response;
    }
}
