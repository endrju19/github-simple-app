package com.example.githubusers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
record RawGithubUser(long id, String login, String name, String type,
                     @JsonProperty("avatar_url") String avatarUrl, long followers,
                     @JsonProperty("created_at") String createdAt,
                     @JsonProperty("public_repos") long publicRepos) {
}
