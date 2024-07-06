package ru.gb.vkr.vkrProject.repository;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface Repository extends JpaRepository<Entity, Long> {
}
