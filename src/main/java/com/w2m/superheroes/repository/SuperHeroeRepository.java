package com.w2m.superheroes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.w2m.superheroes.entity.SuperHeroeEntity;

@Repository
public interface SuperHeroeRepository extends JpaRepository<SuperHeroeEntity, Long> {

	Optional<SuperHeroeEntity> findById(Long id);

	Optional<SuperHeroeEntity> findByName(String name);

	Optional<List<SuperHeroeEntity>> findByNameContaining(String searchCriteria);

}
