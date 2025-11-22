package com.example.umc9th.global.validatior;

import com.example.umc9th.domain.store.enums.code.StoreErrorCode;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.global.annotation.ExistStore;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {

        boolean isValid = storeRepository.findById(id).isPresent();

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(StoreErrorCode.NOT_FOUND.getMessage()).addConstraintViolation();
        }

        return isValid;
    }
}
