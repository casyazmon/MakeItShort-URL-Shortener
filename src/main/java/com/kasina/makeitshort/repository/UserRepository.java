package com.kasina.makeitshort.repository;

import com.kasina.makeitshort.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {
    @Query("{ 'email' : ?0 }")
    Optional<User> findUserByEmail(String email);
}
