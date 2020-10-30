package co.simplon.proj1.dao;

import java.util.List;

import co.simplon.proj1.entities.Ingredient;
import co.simplon.proj1.entities.Recipe;

public interface IngredientDao {
	
   void addIngredient();
   
    List<Ingredient> findByMc(String mc);

	List<Recipe> findRecipesByIngredients(List<Ingredient> ingredients);

	List<Ingredient> ingredientsByRecipeName(String recipe);
   
}
