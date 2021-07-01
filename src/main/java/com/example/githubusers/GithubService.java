package com.example.githubusers;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.Duration;

@Service
class GithubService {

    private static final String baseUri = "https://api.github.com/users/";
    private final RestTemplate restTemplate;

    GithubService(RestTemplateBuilder builder) {
        this.restTemplate = builder.setConnectTimeout(Duration.ofMillis(100))
                .setReadTimeout(Duration.ofMillis(200)).build();
    }

    RawGithubUser fetchUserInfo(String login) {
        return restTemplate.getForObject(URI.create(baseUri + login), RawGithubUser.class);
    }
}
