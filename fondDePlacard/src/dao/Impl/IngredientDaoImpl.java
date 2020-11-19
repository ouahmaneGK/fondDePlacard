package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IngredientDao;
import entities.Ingredient;
import entities.Recipe;
import utils.DataConnect;


public class IngredientDaoImpl implements IngredientDao{

	private Connection con ;

	public IngredientDaoImpl(Connection connection) {
		  
		this.con = connection;
	
	}

	@Override
	public void addIngredient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ingredient> findByMc(String mc) {
	
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		//IngredientDaoImpl topicDao = new IngredientDaoImpl(con);
		
		try {
			PreparedStatement ps= con.prepareStatement(
					"SELECT * FROM ingredient WHERE name like ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ingredients.add(new Ingredient( rs.getInt("id") ,rs.getString("name") ));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ingredients;
		
	}

	@Override
	public List<Recipe> findRecipesByIngredients(List<Ingredient> ingredients) {
		// rajouter la list dans les entité pour pouvoir les injecter, voir sur bdd !!
		
		
		return null;
	}

	@Override
	public List<Ingredient> ingredientsByRecipeName(String recipe) {
		

		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		
		//RecipeDaoImpl recipeDaoImpl = new RecipeDaoImpl(con);
		
		try {
			PreparedStatement ps= con.prepareStatement("SELECT * FROM ingredient i, recipe r, recipe_ingredient ri WHERE r.id = ri.id_recipe AND ri.id_ingredient =i.id AND r.name=?");
			ps.setString(1, recipe);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ingredients.add(    new Ingredient(rs.getInt("id"), rs.getString("name"))   );
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ingredients;

	}

	@Override
	public List<Ingredient> ingredientsByRecipeId(int id) {
		

		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		
		//RecipeDaoImpl recipeDaoImpl = new RecipeDaoImpl(con);
		
		try {
			PreparedStatement ps= con.prepareStatement("SELECT * FROM ingredient i, recipe r, recipe_ingredient ri WHERE r.id = ri.id_recipe AND ri.id_ingredient =i.id AND r.id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ingredients.add(    new Ingredient(rs.getInt("id"), rs.getString("name"))   );
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ingredients;

	}

}
