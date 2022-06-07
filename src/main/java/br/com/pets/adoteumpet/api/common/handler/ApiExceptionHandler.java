package br.com.pets.adoteumpet.api.common.handler;

import br.com.pets.adoteumpet.api.common.dto.ErrorResponse;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private final PropertyNamingStrategies.SnakeCaseStrategy snakeCaseStrategy = new PropertyNamingStrategies.SnakeCaseStrategy();

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {
        var body = ErrorResponse.builder()
                .status(status.value())
                .error(status.getReasonPhrase())
                .cause(exception.getClass().getSimpleName())
                .message("Ocorreu um erro de validação")
                .timestamp(LocalDateTime.now())
                .validationErrors(convertFeildErrors(exception.getBindingResult().getFieldErrors()))
                .build();
        return new ResponseEntity<>(body, status);
    }

    private Map<String, List<String>> convertFeildErrors(List<FieldError> fieldErrors) {
        var errors = new HashMap<String, List<String>>();
        fieldErrors.stream().forEach(fieldError -> {
            var field = snakeCaseStrategy.translate(fieldError.getField());
            var errorMessage = fieldError.getDefaultMessage();
            if (errors.containsKey(field)) {
                errors.get(field).add(errorMessage);
            } else {
                errors.put(field, Stream.of(errorMessage).collect(Collectors.toList()));
            }
        });
        return errors;
    }
}
