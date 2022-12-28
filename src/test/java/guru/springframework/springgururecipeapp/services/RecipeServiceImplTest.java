package guru.springframework.springgururecipeapp.services;

import guru.springframework.springgururecipeapp.domain.Recipe;
import guru.springframework.springgururecipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class RecipeServiceImplTest {

   RecipeServiceImpl recipeService;

   @Mock
   RecipeRepository recipeRepository;

   @BeforeEach
   void setUp() throws Exception {

      MockitoAnnotations.openMocks(this);

      recipeService = new RecipeServiceImpl(recipeRepository);
   }

   @Test
   void getRecipes() throws Exception {

      Recipe recipe = new Recipe();
      Set<Recipe> recipesData = new HashSet<>();
      recipesData.add(recipe);

      when(recipeService.getRecipes()).thenReturn(recipesData);

      Set<Recipe> recipes = recipeService.getRecipes();

      assertEquals(recipes.size(), 1);
      verify(recipeRepository, times(1)).findAll();
   }
}