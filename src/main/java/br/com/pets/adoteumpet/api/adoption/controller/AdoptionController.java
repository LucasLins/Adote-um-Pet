package br.com.pets.adoteumpet.api.adoption.controller;

import br.com.pets.adoteumpet.api.adoption.dto.AdoptionRequest;
import br.com.pets.adoteumpet.api.adoption.dto.AdoptionResponse;
import br.com.pets.adoteumpet.api.adoption.service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdoptionController {

    @Autowired
    private AdoptionService adoptionService;

    @PostMapping("/api/adopt")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AdoptionResponse create(@RequestBody @Valid AdoptionRequest adoptionRequest) {
        return adoptionService.create(adoptionRequest);
    }

    @GetMapping("/api/adoptions")
    public List<AdoptionResponse> findAll() {
        return adoptionService.findAll();
    }

}
