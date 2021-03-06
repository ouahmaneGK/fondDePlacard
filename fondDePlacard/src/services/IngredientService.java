package services;

import java.util.List;

import entities.Ingredient;
import entities.Recipe;

public interface IngredientService {

	 public  void addIngredient();
	   
	  public List<Ingredient> findByMc(String mc);

	  public List<Recipe> findRecipesByIngredients(List<Ingredient> ingredients);

	  public List<Ingredient> ingredientsByRecipeName(String recipe);

	public  List<Ingredient> ingredientsByRecipeId(int id);
}
