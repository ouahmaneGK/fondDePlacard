package services;

import entities.Recipe;

public interface RecipeService {

	public void addRecipe(Recipe recipe);
	public Recipe findRecipeByName(String name);
	public Recipe findRecipesByIngredients();
	public Recipe findRecipeByid(int id );
}
