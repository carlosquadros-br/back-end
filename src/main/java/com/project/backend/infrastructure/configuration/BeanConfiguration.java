package com.project.backend.infrastructure.configuration;

import com.project.backend.core.application.port.outbound.RepositoryPort;
import com.project.backend.core.domain.usecase.SearchUsersImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    SearchUsersImpl searchUsersImpl(RepositoryPort repository){
        return new SearchUsersImpl(repository);
    }
}
