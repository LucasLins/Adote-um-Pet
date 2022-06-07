package br.com.pets.adoteumpet.api.pet.validator;

import br.com.pets.adoteumpet.core.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PetExistsByIdValidator implements ConstraintValidator<PetExistsById, Long> {

    @Autowired
    private PetRepository petRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return petRepository.existsById(value);
    }
}
