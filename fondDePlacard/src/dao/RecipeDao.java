package dao;

import entities.Recipe;

public interface RecipeDao {

	public void addRecipe(Recipe recipe);
	public Recipe findRecipeByName(String name);
	public Recipe findRecipesByIngredients();
	public Recipe findRecipeByid(int id );
	
}
