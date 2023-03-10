package guru.springframework.springgururecipeapp.controllers;

import guru.springframework.springgururecipeapp.repositories.RecipeRepository;
import guru.springframework.springgururecipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class RecipeController {

   private final RecipeService recipeService;

   public RecipeController(RecipeService recipeService) {
      this.recipeService = recipeService;
   }

   @RequestMapping("/recipe/show/{id}")
   public String showById(@PathVariable String id, Model model){

      model.addAttribute(recipeService.findById(Long.parseLong(id)));

      return "recipe/show";
   }

}
