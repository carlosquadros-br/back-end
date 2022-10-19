package com.project.backend.infrastructure.inbound;

import com.project.backend.core.application.port.inbound.SearchUsersPort;
import com.project.backend.core.domain.DatabaseType;
import com.project.backend.core.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private SearchUsersPort searchUsers;

    @GetMapping("/users/{database}")
    public List<User> getUsers(@Validated @NotNull String databaseType) {
        DatabaseType.valueOf(databaseType.toUpperCase());
        return (List<User>) searchUsers.searchAllUsers();
    }
}
