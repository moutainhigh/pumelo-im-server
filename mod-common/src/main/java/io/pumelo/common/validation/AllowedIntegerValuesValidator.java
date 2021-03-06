package io.pumelo.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class AllowedIntegerValuesValidator implements ConstraintValidator<AllowedValues, Integer> {
    private List<Integer> valueList;

    @Override
    public void initialize(AllowedValues constraintAnnotation) {
        valueList = new ArrayList<>();
        for (String val : constraintAnnotation.value()) {
            valueList.add(Integer.parseInt(val));
        }
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (!valueList.contains(value)) {
            return false;
        }
        return true;
    }
}
