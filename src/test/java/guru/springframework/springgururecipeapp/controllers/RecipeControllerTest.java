package guru.springframework.springgururecipeapp.controllers;

import guru.springframework.springgururecipeapp.domain.Recipe;
import guru.springframework.springgururecipeapp.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeControllerTest {

   @Mock
   RecipeService recipeService;

   RecipeController recipeController;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this);

      recipeController = new RecipeController(recipeService);
   }

   @Test
   void testShowById() throws Exception {
      Recipe recipe = new Recipe();
      recipe.setId(1L);

      MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

      when(recipeService.findById(anyLong())).thenReturn(recipe);

      mockMvc.perform(MockMvcRequestBuilders.get("/recipe/show/1"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("recipe/show"));

   }
}