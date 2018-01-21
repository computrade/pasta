package com.demo.pasta.store.business;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pasta.store.data.DataLayer;
import com.demo.pasta.store.data.entity.Pasta;
import com.demo.pasta.store.data.entity.Sauce;
import com.demo.pasta.store.food2fork.client.RecipeApi;
import com.demo.pasta.store.food2fork.model.RecipeResponse;
import com.demo.pasta.store.food2fork.model.RecipeResponseHolder;
import com.demo.pasta.store.food2fork.model.RecipesSearchResponse;
import com.demo.pasta.store.food2fork.model.RecipesSearchResponseHolder;
import com.demo.pasta.store.util.PastaUtils;

@Service
public class BusinessLogic {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DataLayer dl;
	@Autowired
	private RecipeApi recipeApi;

	public List<String> getHowToCook(String iPasta) {
		Pasta pasta = dl.getPastaByName(iPasta);
		return pasta.getHowtocook();
	}

	public double calculateTotalOrderPrice(String iPasta, List<String> saucesNames) {

		List<Sauce> sauces = new ArrayList<Sauce>();

		Pasta pasta = dl.getPastaByName(iPasta);
		for (String sauceName : saucesNames) {
			sauces.add(dl.getSauceByName(sauceName));
		}

		return calculateTotalOrderPrice(pasta, sauces);

	}

	private double calculateTotalOrderPrice(Pasta iPasta, List<Sauce> sauces) {

		double totalPrice = iPasta.getPrice();

		for (Sauce sauce : sauces) {
			totalPrice += sauce.getPrice();
		}

		return totalPrice;
	}

	public RecipeResponse getRecipeResponse(String pasta, List<String> sauces) {

		String id = searchForFirstPastaMatch(pasta, sauces);
		RecipeResponseHolder recipeResponseHolder = recipeApi.getRecipe(id);
		logger.info("The following recipe was return:" + recipeResponseHolder.getRecipe());
		return recipeResponseHolder.getRecipe();

	}

	public Pasta getPastaByName(String name) {

		PastaUtils.validateStringIsNotNullOrEmpty(name);
		return dl.getPastaByName(name);

	}

	public List<String> getAllPastaNames() {

		return dl.getAllPastaNames();

	}

	public List<String> getAllSaucesNames() {

		return dl.getAllSaucesNames();
	}

	private String searchForFirstPastaMatch(String pasta, List<String> sauces) {
		RecipesSearchResponseHolder recipesSearchResponseHolder = recipeApi.searchRecipe(pasta, sauces);
		PastaUtils.validateListIsNotNullOrEmpty(recipesSearchResponseHolder.getRecipes());
		RecipesSearchResponse recipesSearchResponse = recipesSearchResponseHolder.getRecipes().get(0);
		String id = recipesSearchResponse.getRecipe_id();
		logger.info("The following id was found:" + id);
		return id;
	}

}
