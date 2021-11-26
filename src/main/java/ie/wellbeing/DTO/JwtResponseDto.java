package ie.wellbeing.DTO;

public class JwtResponseDto {
    String token;

    public JwtResponseDto() {
    }

    public JwtResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
