package com.kasina.makeitshort.repository;

import com.kasina.makeitshort.mode.MakeItShort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeItShortRepository extends JpaRepository<MakeItShort, Long> {
    MakeItShort findByShortLink(String shortLink);
}
