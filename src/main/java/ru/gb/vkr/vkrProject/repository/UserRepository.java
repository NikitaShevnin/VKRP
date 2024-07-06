package ru.gb.vkr.vkrProject.repository;

import javax.persistence.Id;
import javax.persistence.Table;
import ru.gb.vkr.vkrProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}



