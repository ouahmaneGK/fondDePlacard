package co.simplon.proj1.dao;

import co.simplon.proj1.entities.Recipe;

public interface RecipeDao {

	void addRecipe(Recipe recipe);
	Recipe findRecipeByName(String name);
	Recipe findRecipesByIngredients();
	public Recipe findRecipeByid(int id );
	
}
