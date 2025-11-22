package com.example.umc9th.global.validatior;

import com.example.umc9th.domain.users.exception.code.FoodErrorCode;
import com.example.umc9th.domain.users.repository.FoodRepository;
import com.example.umc9th.global.annotation.ExistFoods;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FoodExistValidator implements ConstraintValidator<ExistFoods, List<Long>> {

    private final FoodRepository foodRepository;

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> foodRepository.existsById(value));

        if (!isValid) {
            // 이 부분에서 아까 디폴트 메시지를 초기화시키고, 새로운 메시지로 덮어씌움
            context.disableDefaultConstraintViolation();;
            context.buildConstraintViolationWithTemplate(FoodErrorCode.NOT_FOUND.getMessage()).addConstraintViolation();
        }

        return isValid;
    }
}
