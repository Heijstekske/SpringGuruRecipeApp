package guru.springframework.springgururecipeapp.repositories;

import guru.springframework.springgururecipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
