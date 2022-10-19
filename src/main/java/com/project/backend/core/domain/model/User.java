package com.project.backend.core.domain.model;

import lombok.*;

@Getter
@Builder
@Data
@AllArgsConstructor
public class User {

    private long id;
    private final String name;
    private final String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

