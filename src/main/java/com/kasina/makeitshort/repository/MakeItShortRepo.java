package com.kasina.makeitshort.repository;

import com.kasina.makeitshort.model.MakeItShort;
import com.kasina.makeitshort.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MakeItShortRepo extends MongoRepository<MakeItShort, String> {
    @Query("{ 'shortLink' : ?0 }")
    MakeItShort findByShortLink(String shortLink);
    List<MakeItShort> findByUser(User user);

    /*@Query("{ 'shortLink' : ?0 }")
    Optional<MakeItShort> findByShortLink(String shortLink);*/
}
