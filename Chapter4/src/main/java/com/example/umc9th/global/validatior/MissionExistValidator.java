package com.example.umc9th.global.validatior;

import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.global.annotation.ExistMission;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMission, Long> {

    private final MissionRepository missionRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {

        boolean isValid = missionRepository.findById(id).isPresent();

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(MissionErrorCode.NOT_FOUND.getMessage()).addConstraintViolation();
        }

        return isValid;
    }
}
