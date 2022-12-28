package guru.springframework.springgururecipeapp.controllers;

import guru.springframework.springgururecipeapp.domain.Category;
import guru.springframework.springgururecipeapp.domain.UnitOfMeasure;
import guru.springframework.springgururecipeapp.repositories.CategoryRepository;
import guru.springframework.springgururecipeapp.repositories.UnitOfMeasureRepository;
import guru.springframework.springgururecipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

   private final RecipeService recipeService;

   public IndexController(RecipeService recipeService) {
      this.recipeService = recipeService;
   }

   @RequestMapping({"", "/", "/index"})
   public String getIndexPage(Model model) {

      model.addAttribute("recipes", recipeService.getRecipes());

      return "index";
   }
}
