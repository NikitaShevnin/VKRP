package ru.gb.vkr.vkrProject.repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface Repository extends JpaRepository<Entity, Long> {
}
