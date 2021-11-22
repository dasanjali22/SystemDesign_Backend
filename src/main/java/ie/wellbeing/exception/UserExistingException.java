package ie.wellbeing.exception;

public class UserExistingException extends RuntimeException {
    public UserExistingException(String exception)
    {
        super(exception);
    }

}
