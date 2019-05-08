package com.bthompson.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bthompson.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
