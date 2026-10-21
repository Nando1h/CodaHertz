package com.codahertz.codahertz.repositories;

import com.codahertz.codahertz.models.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Long> {
}
