package services.impl;

import java.sql.Connection;

import dao.Impl.RecipeDaoImpl;
import entities.Recipe;
import services.RecipeService;
import utils.DataConnect;

public class RecipeServiceImpl implements RecipeService {

	private RecipeDaoImpl recipeDaoImp;
	private Connection con;

	public RecipeServiceImpl() {
		con = DataConnect.getConnection();
		recipeDaoImp = new RecipeDaoImpl(con);
	}

	@Override
	public void addRecipe(Recipe recipe) {
		recipeDaoImp.addRecipe(recipe);
	}

	@Override
	public Recipe findRecipeByName(String name) {
		
		return recipeDaoImp.findRecipeByName(name);
	}

	@Override
	public Recipe findRecipesByIngredients() {
		
		return recipeDaoImp.findRecipesByIngredients();
	}

	@Override
	public Recipe findRecipeByid(int id) {
		
		return recipeDaoImp.findRecipeByid(id);
	}
}
