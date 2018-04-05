package xyz.veiasai.util;


import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import xyz.veiasai.hibernate.result.Result;

import javax.validation.Validation;
import javax.validation.Validator;

public class MyValidator {
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static Result notMatched(BindingResult bindingResult, Result result)
    {
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            result.addMessage(fieldError.getDefaultMessage());
        }
        result.setCode(400);
        return result;
    }

}
