package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.RecipeDao;
import entities.Ingredient;
import entities.Recipe;
import services.impl.IngredientServiceImpl;

public class RecipeDaoImpl implements RecipeDao{

	
	private Connection con ;
	//private IngredientDaoImpl ingredientDaoImp;
	private IngredientServiceImpl ingredientServiceImpl;
	
	
	
	
	public RecipeDaoImpl(Connection con) {
		super();
		this.con = con;
		ingredientServiceImpl = new IngredientServiceImpl();
	}

	@Override
	public void addRecipe(Recipe recipe) {
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO recipe (name, categorie) VALUES (?, ?)" );
		
			ps.setString(1,recipe.getName());
			ps.setString(2, recipe.getCategorie());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Recipe findRecipeByName(String name) {
		
		return null;
	}

	@Override
	public Recipe findRecipesByIngredients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recipe findRecipeByid(int id) {

		Recipe recipe = new Recipe();
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM recipe WHERE id =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				recipe.setId(rs.getInt("id"));
				recipe.setName(rs.getString("name"));
				recipe.setCategorie(rs.getString("categorie"));
				recipe.setPicture(rs.getString("picture"));
				recipe.setScore(rs.getInt("score"));
				
			}
			//on recupère la liste des ingredients pour chaque recette!
			ingredients = ingredientServiceImpl.ingredientsByRecipeId(id);
			recipe.setIngredients(ingredients);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	
		return recipe;
	}
	
	

}
