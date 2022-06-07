package br.com.pets.adoteumpet.api.adoption.mapper;

import br.com.pets.adoteumpet.api.adoption.dto.AdoptionRequest;
import br.com.pets.adoteumpet.api.adoption.dto.AdoptionResponse;
import br.com.pets.adoteumpet.api.pet.mapper.PetMapper;
import br.com.pets.adoteumpet.core.model.Adoption;
import br.com.pets.adoteumpet.core.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdoptionMapper {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;

    public Adoption toModel(AdoptionRequest adoptionRequest) {
        /*
        var adoption = new Adoption();
        adoption.setEmail(adoptionRequest.getEmail());
        adoption.setAmount(adoptionRequest.getAmount());
        adoption.setPet(petRepository.findByIdOrElseThrow(adoptionRequest.getPetId()));
        return adoption;
         */
        return Adoption.builder()
                .email(adoptionRequest.getEmail())
                .amount(adoptionRequest.getAmount())
                .pet(petRepository.findByIdOrElseThrow(adoptionRequest.getPetId()))
                .build();
    }

    public AdoptionResponse toResponse(Adoption adoption) {
        /*
        var adoptionResponse = new AdoptionResponse();
        adoptionResponse.setId(adoption.getId());
        adoptionResponse.setEmail(adoption.getEmail());
        adoptionResponse.setAmount(adoption.getAmount());
        adoptionResponse.setPet(petMapper.toResponse(adoption.getPet()));
        return adoptionResponse;
         */
        return AdoptionResponse.builder()
                .id(adoption.getId())
                .email(adoption.getEmail())
                .amount(adoption.getAmount())
                .pet(petMapper.toResponse(adoption.getPet()))
                .build();
    }
}
