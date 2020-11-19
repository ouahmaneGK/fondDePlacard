package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Recipe implements Serializable{
	
	private int id;
	private String name;
	private String categorie;
	private String picture;
	private int score;
	private List <Ingredient> ingredients = new ArrayList<Ingredient>() ;
	
	public Recipe() {
		
	}

	
	
	

	public Recipe(int id, String name, String categorie, String picture, int score, List<Ingredient> ingredients) {
		super();
		this.id = id;
		this.name = name;
		this.categorie = categorie;
		this.picture = picture;
		this.score = score;
		this.ingredients = ingredients;
	}




	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}


	
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
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

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	

}
