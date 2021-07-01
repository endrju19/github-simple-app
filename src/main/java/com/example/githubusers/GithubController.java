package com.example.githubusers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GithubController {

    private final UserService userService;

    GithubController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/{login}")
    UserInfo getUserInfo(@PathVariable String login) {
        return userService.getUserInfo(login);
    }

}
