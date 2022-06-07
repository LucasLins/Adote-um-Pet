package br.com.pets.adoteumpet.api.adoption.service;

import br.com.pets.adoteumpet.api.adoption.dto.AdoptionRequest;
import br.com.pets.adoteumpet.api.adoption.dto.AdoptionResponse;
import br.com.pets.adoteumpet.api.adoption.mapper.AdoptionMapper;
import br.com.pets.adoteumpet.core.model.Adoption;
import br.com.pets.adoteumpet.core.repository.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptionService {

    @Autowired
    private AdoptionRepository adoptionRepository;

    @Autowired
    private AdoptionMapper adoptionMapper;

    public AdoptionResponse create(AdoptionRequest adoptionRequest) {

        var adoption = adoptionMapper.toModel(adoptionRequest);
        var savedAdoption = adoptionRepository.save(adoption);
        return adoptionMapper.toResponse(savedAdoption);
    }

    public List<AdoptionResponse> findAll() {
        return adoptionRepository.findAll().stream()
                .map(adoptionMapper::toResponse)
                .toList();
    }

}
