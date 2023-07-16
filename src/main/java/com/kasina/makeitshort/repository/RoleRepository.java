package com.kasina.makeitshort.repository;

import com.kasina.makeitshort.model.user.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, Long> {
    Optional<Role> findByName(String roleName);
}
