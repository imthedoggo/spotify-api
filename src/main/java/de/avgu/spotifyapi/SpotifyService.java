package de.avgu.spotifyapi;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SpotifyService {

    @Value("${spotify.basic.auth}")
    private String basicAuth;
    @Value("${spotify.accounts.api.url}")
    private String accountsApiUrl;
    @Value("${spotify.api.url}")
    private String apiUrl;

    public String authenticate() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", basicAuth);
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        HttpEntity<String> request = new HttpEntity<>("grant_type=client_credentials", headers);
        TokenResponse response = restTemplate.postForObject(accountsApiUrl +"/token", request, TokenResponse.class);
        return response.getAccessToken();
    }

    public HttpEntity<Object> getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + this.authenticate());
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        //HttpEntity<Object> entity = new HttpEntity(headers);
        return new HttpEntity(headers);
    }

    public SearchResponse search(String query, String type, Integer limit) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl +"/search")
            .queryParam("q", query)
            .queryParam("type", type)
            .queryParam("limit", limit);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<SearchResponse> response = restTemplate.exchange(
            uriBuilder.toUriString(), HttpMethod.GET, getHeader(), SearchResponse.class);

        return response.getBody();
        }

    public Artist getArtist(String id) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl +"/artists/" + id);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Artist> response = restTemplate.exchange(
            uriBuilder.toUriString(), HttpMethod.GET, getHeader(), Artist.class);

        return response.getBody();
    }

}
