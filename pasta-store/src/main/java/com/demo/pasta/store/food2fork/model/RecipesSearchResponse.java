package com.demo.pasta.store.food2fork.model;

/*
 
 Sample response from:
 
 http://food2fork.com/api/search?key=510b4b833870c160aeb1b8dbb6c10178&sort=r&q=Farfalle,Alfredo
 
"publisher": "Closet Cooking",
  "f2f_url": "http://food2fork.com/view/35382",
  "title": "Jalapeno Popper Grilled Cheese Sandwich",
  "source_url": "http://www.closetcooking.com/2011/04/jalapeno-popper-grilled-cheese-sandwich.html",
  "recipe_id": "35382",
  "image_url": "http://static.food2fork.com/Jalapeno2BPopper2BGrilled2BCheese2BSandwich2B12B500fd186186.jpg",
  "social_rank": 100.0,
  "publisher_url": "http://closetcooking.com"}
*/

public class RecipesSearchResponse {
	
	String publisher;
	String f2f_url;
	String title;
	String source_url;
	String recipe_id;
	String image_url;
	Double social_rank;
	String publisher_url;
	
	public RecipesSearchResponse() {
		super();
	
	}
	
	
	public RecipesSearchResponse(String publisher, String f2f_url, String title, String source_url, String recipe_id,
			String image_url, Double social_rank, String publisher_url) {
		super();
		this.publisher = publisher;
		this.f2f_url = f2f_url;
		this.title = title;
		this.source_url = source_url;
		this.recipe_id = recipe_id;
		this.image_url = image_url;
		this.social_rank = social_rank;
		this.publisher_url = publisher_url;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Double getSocial_rank() {
		return social_rank;
	}
	public void setSocial_rank(Double social_rank) {
		this.social_rank = social_rank;
	}
	public String getPublisher_url() {
		return publisher_url;
	}
	public void setPublisher_url(String publisher_url) {
		this.publisher_url = publisher_url;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RecipesSearchResponse [publisher=").append(publisher).append(", f2f_url=").append(f2f_url)
				.append(", title=").append(title).append(", source_url=").append(source_url).append(", recipe_id=")
				.append(recipe_id).append(", image_url=").append(image_url).append(", social_rank=").append(social_rank)
				.append(", publisher_url=").append(publisher_url).append("]");
		return builder.toString();
	}
	


	
	
	
}
