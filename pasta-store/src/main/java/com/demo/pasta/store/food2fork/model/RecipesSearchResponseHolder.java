package com.demo.pasta.store.food2fork.model;

import java.util.ArrayList;
import java.util.List;

/*
 
 Sample response from food2fork search api:
 
 http://food2fork.com/api/search?key=510b4b833870c160aeb1b8dbb6c10178&sort=r&q=Farfalle,Alfredo
 
{"count": 30, "recipes":
 [
 {"publisher": "Closet Cooking",
  "f2f_url": "http://food2fork.com/view/35382",
  "title": "Jalapeno Popper Grilled Cheese Sandwich",
  "source_url": "http://www.closetcooking.com/2011/04/jalapeno-popper-grilled-cheese-sandwich.html",
  "recipe_id": "35382",
  "image_url": "http://static.food2fork.com/Jalapeno2BPopper2BGrilled2BCheese2BSandwich2B12B500fd186186.jpg",
  "social_rank": 100.0,
  "publisher_url": "http://closetcooking.com"},  
 .....
*/

public class RecipesSearchResponseHolder {

	Integer count;
	List<RecipesSearchResponse> recipes = new ArrayList<RecipesSearchResponse>();
	
	public RecipesSearchResponseHolder() {
		super();
	
	}

	public RecipesSearchResponseHolder(Integer count, List<RecipesSearchResponse> recipes) {
		super();
		this.count = count;
		this.recipes = recipes;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<RecipesSearchResponse> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<RecipesSearchResponse> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RecipesSearchResponseHolder [count=").append(count).append(", recipes=").append(recipes)
				.append("]");
		return builder.toString();
	}

}
