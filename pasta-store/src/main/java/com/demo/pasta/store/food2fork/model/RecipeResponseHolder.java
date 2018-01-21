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

public class RecipeResponseHolder {
	
	RecipeResponse recipe;
	
	public RecipeResponseHolder() {
		super();
	}
	
	public RecipeResponseHolder(RecipeResponse recipe) {
		super();
		this.recipe = recipe;
	}

	public RecipeResponse getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeResponse recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RecipeResponseHolder [recipe=").append(recipe).append("]");
		return builder.toString();
	}
	
}
