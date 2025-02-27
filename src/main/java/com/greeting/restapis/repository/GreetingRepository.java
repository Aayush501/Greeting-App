package com.greeting.restapis.repository;

import com.greeting.restapis.entities.Greeting;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
    Optional<Greeting> findByContentLikeIgnoreCase(@NonNull String content);

    void deleteByContentLikeIgnoreCase(@NonNull String content);
}