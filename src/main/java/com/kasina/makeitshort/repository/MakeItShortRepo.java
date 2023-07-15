package com.kasina.makeitshort.repository;

import com.kasina.makeitshort.model.MakeItShort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MakeItShortRepo extends MongoRepository<MakeItShort, String> {
    @Query("{ 'shortLink' : ?0 }")
    MakeItShort findByShortLink(String shortLink);

    /*@Query("{ 'shortLink' : ?0 }")
    Optional<MakeItShort> findByShortLink(String shortLink);*/
}
