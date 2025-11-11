package uz.xakimov.project1.util;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import uz.xakimov.project1.dto.SensorDTO;

public class SensorValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return SensorDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
