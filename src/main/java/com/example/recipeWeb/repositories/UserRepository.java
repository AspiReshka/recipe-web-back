package com.example.recipeWeb.repositories;

import com.example.recipeWeb.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String username);
}
