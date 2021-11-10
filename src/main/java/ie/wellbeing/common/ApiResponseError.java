package ie.wellbeing.common;

import java.io.Serializable;

/**
 * Error Object returned from API
 *
 */
public class ApiResponseError implements Serializable
{

    /**
     * Serial version UID for this class.
     */
    private static final long serialVersionUID = 3341921954929577691L;

    private int code;
    
    private String message;
    
    private String field;
    
       

    /**
     * Constructor
     * @param code
     * @param message
     * @param field
     */
    public ApiResponseError(int code, String message, String field )
    {
        this.code = code;
        this.message = message;
        this.field = field;
    }

    /**
     * @return the code
     */
    public int getCode()
    {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode( int code )
    {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage( String message )
    {
        this.message = message;
    }

    /**
     * @return the field
     */
    public String getField()
    {
        return field;
    }

    /**
     * @param field the field to set
     */
    public void setField( String field )
    {
        this.field = field;
    }
    
    
}
