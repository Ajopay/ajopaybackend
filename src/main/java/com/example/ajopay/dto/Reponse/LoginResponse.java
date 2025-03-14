package com.example.ajopay.dto.Reponse;

public class LoginResponse {
    private String email;
    private String jwtToken;

    public LoginResponse() {
    }

    public LoginResponse(String email, String jwtToken) {
        this.email = email;
        this.jwtToken = jwtToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "email='" + email + '\'' +
                ", jwtToken='" + jwtToken + '\'' +
                '}';
    }
}
