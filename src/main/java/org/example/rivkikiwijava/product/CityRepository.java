package org.example.rivkikiwijava.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findBySlug(String slug);
    boolean existsCityBySlug(String slug);
}
