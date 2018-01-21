package com.demo.pasta.store.food2fork.model;

import java.util.ArrayList;
import java.util.List;

/*
 * Sample of ge recipe
http://food2fork.com/api/get?key=510b4b833870c160aeb1b8dbb6c10178&rId=47041

{"recipe": 
{"publisher": "The Pioneer Woman",
 "f2f_url": "http://food2fork.com/view/47041",
  "ingredients": 
   ["12 ounces, weight Farfalle (bowtie) Pasta",
    "2 Tablespoons Extra Virgin Olive Oil",
    "1 whole Lemons (more To Taste)",
    "Salt", 
    "Freshly Ground Black Pepper",
    "2 whole Zucchini, Cut Into Small Wedges Or Diced",
    "10 ounces, weight Grape Tomatoes, Halved Lengthwise",
    "1/3 cup Minced Fresh Parsley",
    "6 ounces, weight Crumbled Feta Cheese"],
    "source_url": "http://thepioneerwoman.com/cooking/2011/03/pasta-salad-with-tomatoes-zucchini-and-feta/", 
    "recipe_id": "47041",
     "image_url": "http://static.food2fork.com/5566512470_9e98939ab3_z2766.jpg", 
     "social_rank": 99.99999855322939, 
     "publisher_url": "http://thepioneerwoman.com",
     "title": "Pasta Salad with Tomatoes, Zucchini, and Feta"
     }}
     
     */

public class RecipeResponse {
	
	String publisher;
	String f2f_url;
	List<String> ingredients = new ArrayList<String>();
	String source_url;
	String recipe_id;
	String image_url;
	String social_rank;
	String publisher_url;
	String title;
	
	public RecipeResponse() {
		super();
	
	}
	
	
	public RecipeResponse(String publisher, String f2f_url, List<String> ingredients, String source_url,
			String recipe_id, String image_url, String social_rank, String publisher_url, String title) {
		super();
		this.publisher = publisher;
		this.f2f_url = f2f_url;
		this.ingredients = ingredients;
		this.source_url = source_url;
		this.recipe_id = recipe_id;
		this.image_url = image_url;
		this.social_rank = social_rank;
		this.publisher_url = publisher_url;
		this.title = title;
	}
	
	
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getF2f_url() {
		return f2f_url;
	}
	public void setF2f_url(String f2f_url) {
		this.f2f_url = f2f_url;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	public String getSource_url() {
		return source_url;
	}
	public void setSource_url(String source_url) {
		this.source_url = source_url;
	}
	public String getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(String recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getSocial_rank() {
		return social_rank;
	}
	public void setSocial_rank(String social_rank) {
		this.social_rank = social_rank;
	}
	public String getPublisher_url() {
		return publisher_url;
	}
	public void setPublisher_url(String publisher_url) {
		this.publisher_url = publisher_url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RecipeResponse [publisher=").append(publisher).append(", f2f_url=").append(f2f_url)
				.append(", ingredients=").append(ingredients).append(", source_url=").append(source_url)
				.append(", recipe_id=").append(recipe_id).append(", image_url=").append(image_url)
				.append(", social_rank=").append(social_rank).append(", publisher_url=").append(publisher_url)
				.append(", title=").append(title).append("]");
		return builder.toString();
	}

	
	

}
