package com.project.backend.infrastructure.outbound.repository.mongodb;

import com.project.backend.infrastructure.outbound.repository.mongodb.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBRepository extends MongoRepository<UserDocument, Long> {

    @Query("{id:'?0'}")
    UserDocument findUserById(Long id);


}
