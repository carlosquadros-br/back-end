package com.project.backend.infrastructure.outbound.repository.mongodb;

import com.project.backend.core.application.port.outbound.RepositoryPort;
import com.project.backend.core.domain.model.User;
import com.project.backend.infrastructure.outbound.repository.h2databaseengine.entity.UserEntity;
import com.project.backend.infrastructure.outbound.repository.mongodb.document.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MongoDBRespositoryPortImpl implements RepositoryPort {

    @Autowired
    MongoDBRepository repository;

    @Override
    public List<User> getUsers() {
        var result = new ArrayList<User>();
        repository.findAll().forEach(userDocument -> result.add(convertEntityToModel(userDocument)));
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    private User convertEntityToModel(UserDocument userDocument){
        return  User.builder().id(userDocument.getId()).name(userDocument.getName()).email(userDocument.getEmail()).build();
    }
}

