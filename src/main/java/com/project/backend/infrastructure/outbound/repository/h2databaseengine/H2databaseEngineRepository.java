package com.project.backend.infrastructure.outbound.repository.h2databaseengine;

import com.project.backend.infrastructure.outbound.repository.h2databaseengine.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface H2databaseEngineRepository extends CrudRepository<UserEntity, Long> {
}
