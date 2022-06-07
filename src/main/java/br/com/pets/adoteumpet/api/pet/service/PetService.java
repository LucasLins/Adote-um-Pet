package br.com.pets.adoteumpet.api.pet.service;

import br.com.pets.adoteumpet.api.pet.dto.PetRequest;
import br.com.pets.adoteumpet.api.pet.dto.PetResponse;
import br.com.pets.adoteumpet.api.pet.mapper.PetMapper;
import br.com.pets.adoteumpet.core.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;

    public List<PetResponse> findAll() {

        return petRepository.findAll()
                .stream()
                .map(petMapper::toResponse)
                .toList();
    }

    public PetResponse create(PetRequest petRequest) {

        var pet = petMapper.toModel(petRequest);
        var savedPet = petRepository.save(pet);
        return petMapper.toResponse(savedPet);
    }
}
