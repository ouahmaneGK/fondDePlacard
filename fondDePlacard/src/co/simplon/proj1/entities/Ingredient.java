package co.simplon.proj1.entities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ingredient {
	
	private int id;
	private String name;
	private List <Recipe> recipes = new ArrayList<Recipe>() ;
	
	public Ingredient() {
	
	}


	
	public Ingredient(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}


	public Ingredient(int id, String name, List<Recipe> recipes) {
		super();
		this.id = id;
		this.name = name;
		this.recipes = recipes;
	}


	public List<Recipe> getRecipes() {
		return recipes;
	}





	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
