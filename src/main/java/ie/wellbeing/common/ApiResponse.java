package ie.wellbeing.common;

import java.io.Serializable;

/**
 * API Service response class.
 *
 */

public class ApiResponse implements Serializable
{

    /**
     * Serial version UID for this class.
     */
    private static final long serialVersionUID = -6792356705494495320L;

    private int status;

    private Object data;

    //Has Error Message defined
    private ApiResponseError error;

    
    
    /**
     * Constructor
     * @param status
     */
    public ApiResponse(int status )
    {
        this.status = status;
    }

    /**
     * Return status
     * @return integer value
     */
    public int getStatus()
    {
        return status;
    }

    /**
     * Set status
     * @param status
     */
    public void setStatus( int status )
    {
        this.status = status;
    }

    /**
     * Return data
     * @return object
     */
    public Object getData()
    {
        return data;
    }

    /**
     * Set data value
     * @param data
     */
    public void setData( Object data )
    {
        this.data = data;
    }

    /**
     * @return the error
     */
    public ApiResponseError getError()
    {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError( ApiResponseError error )
    {
        this.error = error;
    }
}
