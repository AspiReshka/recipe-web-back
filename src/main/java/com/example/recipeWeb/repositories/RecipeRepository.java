package com.example.recipeWeb.repositories;

import com.example.recipeWeb.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RecipeRepository extends JpaRepository<Recipe, Long>{
}
