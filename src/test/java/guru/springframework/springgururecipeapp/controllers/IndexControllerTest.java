package guru.springframework.springgururecipeapp.controllers;

import guru.springframework.springgururecipeapp.domain.Recipe;
import guru.springframework.springgururecipeapp.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class IndexControllerTest {

   @Mock
   RecipeService recipeService;

   @Mock
   Model model;

   IndexController controller;

   @BeforeEach
   void setUp()  throws Exception {
      MockitoAnnotations.openMocks(this);

      controller = new IndexController(recipeService);
   }

   @Test
   public void testMockMVC() throws Exception {
      MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

      mockMvc.perform(MockMvcRequestBuilders.get("/"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("index"));
   }

   @Test
   void getIndexPage() throws Exception {

      //given
      Set<Recipe> recipes = new HashSet<>();
      recipes.add(new Recipe());

      Recipe recipe = new Recipe();
      recipe.setId(1L);

      recipes.add(recipe);

      when(recipeService.getRecipes()).thenReturn(recipes);

      ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

      //when
      String viewName = controller.getIndexPage(model);

      //then
      assertEquals("index", viewName);
      verify(recipeService, times(1)).getRecipes();
      verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
      Set<Recipe> setInController = argumentCaptor.getValue();
      assertEquals(2, setInController.size());
   }
}