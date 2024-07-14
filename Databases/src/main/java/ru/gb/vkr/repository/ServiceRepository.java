package ru.gb.vkr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.vkr.model.Service;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findByEnabled(boolean enabled);
    List<Service> findByNameContaining(String name);
}


