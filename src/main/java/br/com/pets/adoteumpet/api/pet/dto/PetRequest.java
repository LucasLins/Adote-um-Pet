package br.com.pets.adoteumpet.api.pet.dto;

import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetRequest {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String story;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    @URL
    private String picture;
}
