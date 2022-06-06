package br.com.pets.adoteumpet.api.pet.mapper;

import br.com.pets.adoteumpet.api.pet.dto.PetResponse;
import br.com.pets.adoteumpet.core.model.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    public PetResponse toResponse(Pet pet) {
        var petResponse = new PetResponse();
        petResponse.setId(pet.getId());
        petResponse.setName(pet.getName());
        petResponse.setStory(pet.getStory());
        petResponse.setPicture(pet.getPicture());
        return petResponse;
    }
}
