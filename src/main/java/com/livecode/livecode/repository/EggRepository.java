package com.livecode.livecode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livecode.livecode.models.Egg;

@Repository
public interface EggRepository extends JpaRepository<Egg, Long> {
}
