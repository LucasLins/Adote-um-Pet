package br.com.pets.adoteumpet.api.adoption.controller;

import br.com.pets.adoteumpet.api.adoption.dto.AdoptionRequest;
import br.com.pets.adoteumpet.api.adoption.dto.AdoptionResponse;
import br.com.pets.adoteumpet.api.adoption.mapper.AdoptionMapper;
import br.com.pets.adoteumpet.core.repository.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdoptionController {

    @Autowired
    private AdoptionRepository repository;

    @Autowired
    private AdoptionMapper mapper;

    @PostMapping("/api/adoptions")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AdoptionResponse create(@RequestBody AdoptionRequest adoptionRequest) {
        var adoption = mapper.toModel(adoptionRequest);
        var savedAdoption = repository.save(adoption);
        return mapper.toResponse(savedAdoption);
    }

}
