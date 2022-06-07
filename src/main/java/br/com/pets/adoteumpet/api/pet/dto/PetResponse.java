package br.com.pets.adoteumpet.api.pet.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetResponse {

    private Long id;
    private String name;
    private String story;
    private String picture;

}
