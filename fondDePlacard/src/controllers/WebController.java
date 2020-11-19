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

import dao.IngredientDao;
import dao.Impl.IngredientDaoImpl;
import dao.Impl.RecipeDaoImpl;
import entities.Ingredient;
import entities.Recipe;
import services.impl.IngredientServiceImpl;
import services.impl.RecipeServiceImpl;
import utils.*;


@Path("webService")
public class WebController {


	//private Connection connection;
	//private RecipeDaoImpl recipeDaoImp;
	//private IngredientDao ingredientDaoImp;
	private RecipeServiceImpl recipeServiceImpl;
	private IngredientServiceImpl ingredientServiceImpl;
	
	public WebController( ) {
		  // connection= DataConnect.getConnection();
		  // recipeDaoImp =  new RecipeDaoImpl(connection);
		   recipeServiceImpl = new RecipeServiceImpl();
		  // ingredientDaoImp=new IngredientDaoImpl(connection);
		   ingredientServiceImpl = new IngredientServiceImpl();
		   
	}
	
	
	
	@POST
	@Path("/createRecipe")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

	public Recipe saveRecipe(Recipe recipe){
		recipeServiceImpl.addRecipe(recipe);
		return recipe;
		
	}
	
	@GET
	@Path("/getRecipe/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Recipe getRecipe(@PathParam(value="id") int id) {
		return recipeServiceImpl.findRecipeByid(  id );
	}
	
	
	
	
	
	
	@GET
	@Path("/findIngr/{mc}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Ingredient> ingredientsByName(@PathParam(value="mc")  String mc){
		
		return ingredientServiceImpl.findByMc(mc);
		 
	}
	
	
	@GET
	@Path("/ingredsByRecipe/{recipe}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Ingredient> ingredientsByRecipeName(@PathParam(value="recipe") String recipe){
		
		return ingredientServiceImpl.ingredientsByRecipeName(recipe);
		
		
	}
	
	/*
	@GET
	@Path("/ingredsByRecipe/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Ingredient> ingredientsByRecipeId(@PathParam(value="id") int id){
		
		return ingredientServiceImpl.ingredientsByRecipeId(id);
		
		
	}
	*/
	
	public List<Recipe> recipesByIngredients(List<Ingredient> ingredients) {
		
		return ingredientServiceImpl.findRecipesByIngredients(ingredients);
	}
}

