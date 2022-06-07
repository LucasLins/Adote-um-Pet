package br.com.pets.adoteumpet.api.common.dto;

import lombok.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private int status;
    private String error;
    private String cause;
    private String message;
    private LocalDateTime timestamp;
    private Map<String, List<String>> validationErrors;

}
