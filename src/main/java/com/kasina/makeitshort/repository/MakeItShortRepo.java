package com.kasina.makeitshort.repository;

import com.kasina.makeitshort.mode.MakeItShort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface MakeItShortRepo extends MongoRepository<MakeItShort, Long> {
    @Query("{ 'shortLink' : ?0 }")
    MakeItShort findByShortLink(String shortLink);

    /*@Query("{ 'shortLink' : ?0 }")
    Optional<MakeItShort> findByShortLink(String shortLink);*/
}
