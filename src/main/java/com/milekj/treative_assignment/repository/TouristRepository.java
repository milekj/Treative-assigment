package com.milekj.treative_assignment.repository;

import com.milekj.treative_assignment.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
}
