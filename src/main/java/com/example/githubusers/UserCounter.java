package com.example.githubusers;

import javax.persistence.*;

@Entity
class UserCounter {

    @Id
    private String login;

    @Column(name = "request_count")
    private Long requestCount = 0L;

    UserCounter(String login) {
        this.login = login;
    }

    UserCounter() {
    }

    void incrementCounter() {
        requestCount++;
    }
}
