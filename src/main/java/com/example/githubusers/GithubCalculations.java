package com.example.githubusers;

class GithubCalculations {
    public static double calculate(long followers, long publicRepos) {
        return 6.0 / followers * (2 + publicRepos);
    }
}
