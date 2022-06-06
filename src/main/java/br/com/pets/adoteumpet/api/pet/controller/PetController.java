package br.com.pets.adoteumpet.api.pet.controller;

import br.com.pets.adoteumpet.api.pet.dto.PetResponse;
import br.com.pets.adoteumpet.api.pet.mapper.PetMapper;
import br.com.pets.adoteumpet.core.model.Pet;
import br.com.pets.adoteumpet.core.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetRepository repository;

    @Autowired
    private PetMapper mapper;

    @GetMapping("/api/pets")
    public List<PetResponse> findAll() {
        var pets = repository.findAll();
        var petResponses = new ArrayList<PetResponse>();
        for (Pet pet : pets) {
            petResponses.add(mapper.toResponse(pet));
        }
        return petResponses;
    }

}
