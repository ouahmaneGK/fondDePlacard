package co.simplon.proj1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.simplon.proj1.entities.Recipe;

public class RecipeDaoImpl implements RecipeDao{

	
	Connection con ;
	
	
	
	
	public RecipeDaoImpl(Connection con) {
		super();
		this.con = con;
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		return recipe;
	}
	
	

}
