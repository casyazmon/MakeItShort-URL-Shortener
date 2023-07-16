package com.kasina.makeitshort.repository;

import com.kasina.makeitshort.model.MakeItShort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MakeItShortRepo extends MongoRepository<MakeItShort, String> {
    @Query("{ 'shortLink' : ?0 }")
    MakeItShort findByShortLink(String shortLink);

    @Query(value = "{'user.id': ?0}")
    List<MakeItShort> queryZoneByBuildingId(@Param("id") Long id);

    /*@Query("{ 'shortLink' : ?0 }")
    Optional<MakeItShort> findByShortLink(String shortLink);*/
}
