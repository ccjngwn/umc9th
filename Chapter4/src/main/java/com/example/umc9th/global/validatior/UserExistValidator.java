package com.example.umc9th.global.validatior;

import com.example.umc9th.domain.users.exception.code.UserErrorCode;
import com.example.umc9th.domain.users.repository.UsersRepository;
import com.example.umc9th.global.annotation.ExistUser;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserExistValidator implements ConstraintValidator<ExistUser, Long> {

    private final UsersRepository usersRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {

        boolean isValid = usersRepository.findById(id).isPresent();

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(UserErrorCode.NOT_FOUND.getMessage()).addConstraintViolation();
        }

        return isValid;
    }
}
