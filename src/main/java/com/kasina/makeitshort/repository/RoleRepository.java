package com.kasina.makeitshort.repository;

import com.kasina.makeitshort.model.user.ERole;
import com.kasina.makeitshort.model.user.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(String name);
}
