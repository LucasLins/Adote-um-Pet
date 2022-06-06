package br.com.pets.adoteumpet.core.repository;

import br.com.pets.adoteumpet.core.model.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {

}
