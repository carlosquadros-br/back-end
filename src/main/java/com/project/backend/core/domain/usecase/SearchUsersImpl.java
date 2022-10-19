package com.project.backend.core.domain.usecase;

import com.project.backend.core.application.port.inbound.SearchUsersPort;
import com.project.backend.core.application.port.outbound.RepositoryPort;
import com.project.backend.core.domain.model.User;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SearchUsersImpl implements SearchUsersPort {

    private final List<RepositoryPort> repository;

    @Override
    public List<User> searchAllUsers() {
        return repository.getUsers();
    }
}
