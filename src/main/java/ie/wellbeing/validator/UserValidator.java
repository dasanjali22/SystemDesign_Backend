package ie.wellbeing.validator;

import java.util.regex.Pattern;

import ie.wellbeing.DTO.UserRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserValidator
{
    @Value("${spring.user.email}")
    String errorEmail;
    @Value("${spring.user.password}")
    String errorPassword;
    //validating signup details
    public String validate(UserRequestDto userRequestDto)
    {
        if(checkEmail(userRequestDto.getuEmail()))
        {
            if(checkPassword(userRequestDto.getuConfirmPassword()))
            {
                return null;
            }
            else
                return errorPassword;
        }
        else
            return errorEmail;
    }
    boolean checkEmail(String email)
    {
        if(Pattern.matches("[a-zA-Z0-9./]*@[a-z./]*[.][a-z]{2,3}", email))
        {
            return true;
        }
        return false;
    }

    boolean checkPassword(String password)
    {
        if(Pattern.matches("^.*(?=.{8,})((?=.*[!@#$%^&*()\\-_=+{};:,<.>]){1})(?=.*\\d)((?=.*[a-z]){1})((?=.*[A-Z]){1}).*$", password))
        {
            return true;
        }
        return false;
    }

}