package br.insper.finalzambom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.insper.finalzambom.model.User;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    public UserService(@Autowired RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean isAdmin(String token) {
        ResponseEntity<User> response = restTemplate.exchange(
                "http://184.72.80.215/usuario/validate",
                HttpMethod.POST,
                new HttpEntity<>(createAuthHeaders(token)),
                User.class);

        return response.getBody().getRole().equals("ADMIN");
    }

    public boolean isAuthorized(String token) {
        // Call /usuario/validate with token to check user role
        ResponseEntity<User> response = restTemplate.exchange(
                "http://184.72.80.215/usuario/validate",
                HttpMethod.POST,
                new HttpEntity<>(createAuthHeaders(token)),
                User.class);

        return response.getBody().getRole().equals("ADMIN") || response.getBody().getRole().equals("DEVELOPER");
    }

    private HttpHeaders createAuthHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        return headers;
    }
}

