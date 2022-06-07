package br.com.pets.adoteumpet.api.adoption.dto;

import br.com.pets.adoteumpet.api.pet.validator.PetExistsById;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AdoptionRequest {

    @NotNull
    @NotEmpty
    @Email
    @Size(max = 255)
    private String email;

    @NotNull
    @Min(10)
    @Max(100)
    private BigDecimal amount;

    @NotNull
    @Positive
    @PetExistsById
    private Long petId;

}
