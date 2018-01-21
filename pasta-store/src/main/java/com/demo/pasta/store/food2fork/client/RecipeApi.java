package com.demo.pasta.store.food2fork.client;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.pasta.store.food2fork.model.RecipeResponseHolder;
import com.demo.pasta.store.food2fork.model.RecipesSearchResponseHolder;
import com.demo.pasta.store.util.PastaUtils;

@Service
public class RecipeApi {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static String BASE_URL = "http://food2fork.com/api/";
	private static String KEY = "510b4b833870c160aeb1b8dbb6c10178";
		
	// sample http://food2fork.com/api/search?key=510b4b833870c160aeb1b8dbb6c10178&sort=r&q=Farfalle,Alfredo
	private String SEARCH_SORT_URL = BASE_URL + "search?key=" + KEY + "&sort=r&q=";
	// http://food2fork.com/api/get?key=510b4b833870c160aeb1b8dbb6c10178&rId=47041
	private String GET_RECIPE_URL = BASE_URL + "get?key=" + KEY + "&rId=";
			

	RestTemplate restTemplate;
	HttpEntity<String> entity;

	
	public RecipeApi(){
		this.restTemplate = new RestTemplate();
		changeResponseToJson(restTemplate);
		addUserAgent();
		
	}


	//To resolve ${} in @Value
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	public RecipesSearchResponseHolder searchRecipe(String pasta, List<String> sauces) {
		
		PastaUtils.validateStringIsNotNullOrEmpty(pasta);

		StringBuilder builder = new StringBuilder();
		builder.append(pasta);
		for (String sauce : sauces) {
			builder.append("," + sauce);
		}
	
        ResponseEntity<RecipesSearchResponseHolder> responseEntity = restTemplate.exchange(SEARCH_SORT_URL + builder.toString(),  HttpMethod.GET, entity, RecipesSearchResponseHolder.class);
		logger.info("got the following response from :" + SEARCH_SORT_URL + builder.toString() + ": *****   "+ responseEntity.getBody());
		
		return responseEntity.getBody();

	}
	
	
	public RecipeResponseHolder getRecipe(String rId) {
		
		PastaUtils.validateStringIsNotNullOrEmpty(rId);

		ResponseEntity<RecipeResponseHolder> responseEntity = restTemplate.exchange(GET_RECIPE_URL + rId,  HttpMethod.GET, entity, RecipeResponseHolder.class);
		logger.info("got the following response from :" + GET_RECIPE_URL + rId  + ":  ****  "
				+ responseEntity.getBody());
		return responseEntity.getBody();

	}
	
	private void addUserAgent() {
		//Create the user agent - for not getting 403 - Forbidden exception.
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        this.entity = new HttpEntity<String>("parameters", headers);
	}


	private void changeResponseToJson(RestTemplate restTemplate) {
		//add this getInterceptors because the food2fork return content-type →text/html; charset=utf-8 and not JSON
		restTemplate.getInterceptors().add((request, body, execution) -> {
            ClientHttpResponse response = execution.execute(request,body);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return response;
        });
	}
	
	
	

}
