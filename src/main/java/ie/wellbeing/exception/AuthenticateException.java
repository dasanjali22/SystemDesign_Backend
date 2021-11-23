package ie.wellbeing.exception;

public class AuthenticateException extends RuntimeException{
    private static final long serialVersionUID = -6198470968618298220L;

    public AuthenticateException(String message){
        super(message);
    }
    public AuthenticateException(String message,Throwable cause){
        super(message,cause);
    }
}
