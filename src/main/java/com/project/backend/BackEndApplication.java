package com.project.backend;

import com.project.backend.infrastructure.outbound.repository.h2databaseengine.H2databaseEngineRepository;
import com.project.backend.infrastructure.outbound.repository.h2databaseengine.entity.UserEntity;
import com.project.backend.infrastructure.outbound.repository.mongodb.document.UserDocument;
import com.project.backend.infrastructure.outbound.repository.mongodb.MongoDBRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
@EnableMongoRepositories
public class BackEndApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
        System.out.println("Working back-end ...");
    }
    @Bean
    CommandLineRunner init(H2databaseEngineRepository userRepository) {
        return args -> {
			Stream.of("Jhon", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				UserEntity user = UserEntity.builder().name(name).email(name.toLowerCase() + "@domain.com").build();
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
    }

    @Bean
    CommandLineRunner init2(MongoDBRepository mongoDBRepository){
        return args -> {
            Stream.of("Jhon", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                UserDocument user = new UserDocument(UUID.randomUUID().toString(), name,name.toLowerCase() + "@domain.com");
                mongoDBRepository.save(user);
            });
            mongoDBRepository.findAll().forEach(System.out::println);
        };
    }

}
