package ie.wellbeing.common;

/**
 * Builder class for {@link ApiResponse}
 *
 */
public class ApiResponseBuilder
{
    private ApiResponse res;

    /**
     * @param
     */
    private ApiResponseBuilder(int status )
    {

        res = new ApiResponse( status );
    }
    
    /**
     * Use this for success return
     * @return
     */
    public static ApiResponseBuilder success()
    {
        return new ApiResponseBuilder(ResponseStatus.SUCCESS );
    }
    
    /**
     * Use this for failure return
     * @return
     */
    public static ApiResponseBuilder failure()
    {
        return new ApiResponseBuilder(ResponseStatus.FAILURE );
    }

    /**
     * Set the data object
     * @param data
     * @return
     */
    public ApiResponseBuilder data( Object data )
    {
        res.setData( data );
        return this;
    }
    
    /**
     * Set the Error details
     * @param code
     * @param message
     * @param field
     * @return
     */
    public ApiResponseBuilder error( int code, String message, String field )
    {
        ApiResponseError error = new ApiResponseError( code, message, field );
        res.setError( error );
        return this;
    }
    
    /**
     * Build and returns the ApiResponse object. Call this at end.
     * @return
     */
    public ApiResponse build()
    {
        return res;
    }
}
