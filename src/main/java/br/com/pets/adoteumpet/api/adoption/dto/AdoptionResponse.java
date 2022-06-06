package br.com.pets.adoteumpet.api.adoption.dto;

import br.com.pets.adoteumpet.api.pet.dto.PetResponse;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdoptionResponse {

    private Long id;
    private String email;
    private BigDecimal amount;
    private PetResponse pet;
}
