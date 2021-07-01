package com.example.githubusers;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final GithubService githubService;
    private final UserRepository userRepository;

    UserService(GithubService githubService, UserRepository userRepository) {
        this.githubService = githubService;
        this.userRepository = userRepository;
    }

    public UserInfo getUserInfo(String login) {
        RawGithubUser user = githubService.fetchUserInfo(login);
        double calculations = GithubCalculations.calculate(user.followers(), user.publicRepos());
        incrementCounter(login);
        return new UserInfo(user.id(), user.login(), user.name(), user.type(), user.avatarUrl(), user.createdAt(),
                calculations);
    }

    private void incrementCounter(String login) {
        UserCounter userCounter = userRepository.findById(login).orElseGet(() -> new UserCounter(login));
        userCounter.incrementCounter();
        userRepository.save(userCounter);
    }
}
