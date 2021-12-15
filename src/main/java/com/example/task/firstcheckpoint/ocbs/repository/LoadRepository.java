package com.example.task.firstcheckpoint.ocbs.repository;

import com.example.task.firstcheckpoint.ocbs.dtos.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoadRepository extends JpaRepository<Load, Long> {

  @Query("SELECT load FROM Load load WHERE load.loadNumber = ?1")
  Optional<Load> findLoadByLoadNumber(String loadNumber);
}
