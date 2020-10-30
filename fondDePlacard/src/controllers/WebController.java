package controllers;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.simplon.proj1.dao.IngredientDao;
import co.simplon.proj1.dao.IngredientDaoImpl;
import co.simplon.proj1.dao.RecipeDaoImpl;
import co.simplon.proj1.entities.Ingredient;
import co.simplon.proj1.entities.Recipe;
import utils.*;


@Path("webService")
public class WebController {


	private Connection connection;
	private RecipeDaoImpl recipeDaoImp;
	private IngredientDao ingredientDaoImp;
	
	public WebController( ) {
		   connection= DataConnect.getConnection();
		   recipeDaoImp =  new RecipeDaoImpl(connection);
		   ingredientDaoImp=new IngredientDaoImpl(connection);
		   
	}
	
	
	
	@POST
	@Path("/createRecipe")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

	public Recipe saveRecipe(Recipe recipe){
		recipeDaoImp.addRecipe(recipe);
		return recipe;
		
	}
	
	@GET
	@Path("/getRecipe/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Recipe getRecipe(@PathParam(value="id") int id) {
		return recipeDaoImp.findRecipeByid(  id );
	}
	
	
	@GET
	@Path("/findIngr/{mc}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Ingredient> ingredientsByName(@PathParam(value="mc")  String mc){
		
		return ingredientDaoImp.findByMc(mc);
		 
	}
	
	@GET
	@Path("/ingredsByRecipe/{recipe}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Ingredient> ingredientsByRecipeName(@PathParam(value="recipe") String recipe){
		
		return ingredientDaoImp.ingredientsByRecipeName(recipe);
		
		
	}
	
	
	
	public List<Recipe> recipesByIngredients(List<Ingredient> ingredients) {
		
		return ingredientDaoImp.findRecipesByIngredients(ingredients);
	}
}

