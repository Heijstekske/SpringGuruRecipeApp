package guru.springframework.springgururecipeapp.services;

import guru.springframework.springgururecipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

   Set<Recipe> getRecipes();
}
