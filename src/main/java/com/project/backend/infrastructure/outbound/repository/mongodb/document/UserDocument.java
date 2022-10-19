package com.project.backend.infrastructure.outbound.repository.mongodb.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("Users")
@AllArgsConstructor
@Getter
public class UserDocument {

    @Id
    private String id;

    private String name;

    private String email;
}

