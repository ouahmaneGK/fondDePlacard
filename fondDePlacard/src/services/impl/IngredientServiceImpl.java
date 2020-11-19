package services.impl;

import java.sql.Connection;
import java.util.List;

import dao.Impl.IngredientDaoImpl;
import entities.Ingredient;
import entities.Recipe;
import services.IngredientService;
import utils.DataConnect;

public class IngredientServiceImpl implements IngredientService {
	
	private Connection connection;
	private IngredientDaoImpl ingredientDaoImp;


	public IngredientServiceImpl() {
		connection= DataConnect.getConnection();
		ingredientDaoImp = new IngredientDaoImpl(connection);
	}

	@Override
	public void addIngredient() {
		
		
	}

	@Override
	public List<Ingredient> findByMc(String mc) {
		
		return ingredientDaoImp.findByMc(mc);
	}

	@Override
	public List<Recipe> findRecipesByIngredients(List<Ingredient> ingredients) {
		
		return ingredientDaoImp.findRecipesByIngredients(ingredients);
	}

	@Override
	public List<Ingredient> ingredientsByRecipeName(String recipe) {
		
		return ingredientDaoImp.ingredientsByRecipeName(recipe);
	}
	
	@Override
	public List<Ingredient> ingredientsByRecipeId(int id) {
		
		return ingredientDaoImp.ingredientsByRecipeId(id);
	}

}
