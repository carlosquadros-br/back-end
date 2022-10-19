package com.project.backend.infrastructure.outbound.repository.h2databaseengine;

import com.project.backend.core.application.port.outbound.RepositoryPort;
import com.project.backend.core.domain.model.User;
import com.project.backend.infrastructure.outbound.repository.h2databaseengine.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class H2databaseEngineRepositoryPortImpl implements RepositoryPort {

    @Autowired
    H2databaseEngineRepository repository;

    @Override
    public List<User> getUsers() {
        var result = new ArrayList<User>();
        repository.findAll().forEach(user-> result.add(convertEntityToModel(user)));
        return result;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    private User convertEntityToModel(UserEntity user){
        return  User.builder().id(user.getId()).name(user.getName()).email(user.getEmail()).build();
    }
}
