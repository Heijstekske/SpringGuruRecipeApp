package guru.springframework.springgururecipeapp.services;

import guru.springframework.springgururecipeapp.domain.Recipe;
import guru.springframework.springgururecipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

   private final RecipeRepository recipeRepository;

   public RecipeServiceImpl(RecipeRepository recipeRepository) {
      this.recipeRepository = recipeRepository;
   }

   @Override
   public Set<Recipe> getRecipes() {
      log.debug("I'm in the service");

      Set<Recipe> recipeSet = new HashSet<>();
      recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
      return recipeSet;
   }

   @Override
   public Recipe findById(long l) {
      Optional<Recipe> optionalRecipe = recipeRepository.findById(l);
      if (optionalRecipe.isEmpty()){
         throw new RuntimeException("Recipe not found");
      }
      return optionalRecipe.get();
   }
}
