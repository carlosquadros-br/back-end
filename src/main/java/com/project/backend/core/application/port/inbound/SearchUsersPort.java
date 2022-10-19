package com.project.backend.core.application.port.inbound;

import com.project.backend.core.domain.model.User;

import java.util.List;

public interface SearchUsersPort {

    List<User> searchAllUsers();
}
