package com.project.backend.core.application.repository;

import com.project.backend.core.domain.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getUsers();

    boolean addUser(User user);

}
