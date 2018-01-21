package com.demo.pasta.store;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pasta.store.business.BusinessLogic;
import com.demo.pasta.store.food2fork.model.RecipeResponse;
import com.demo.pasta.store.model.OrderRequest;
import com.demo.pasta.store.model.OrderResponse;
import com.demo.pasta.store.util.PastaUtils;

@RestController
public class OrderController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	BusinessLogic businessLogic;
	
	@RequestMapping(value="/order",method=RequestMethod.POST)
	public OrderResponse orderPasta(@RequestBody OrderRequest orderRequest) {

		logger.debug("This is a debug message from /order end point");
		OrderResponse orderResponse = buildOrderResponse(counter.incrementAndGet(), orderRequest);
		return orderResponse;
	}
	
	
	private OrderResponse buildOrderResponse(long incrementAndGet, OrderRequest orderRequest) {
		
		OrderResponse oderResponse = new OrderResponse();
		String pasta = orderRequest.getPasta();
		List<String> sauces = orderRequest.getSauces();
		
		PastaUtils.validateStringIsNotNullOrEmpty(pasta);
		PastaUtils.validateListIsNotNullOrEmpty(sauces);
		
		List<String> howToCook = businessLogic.getHowToCook(pasta);
		oderResponse.setCook(howToCook);
		Double totalPrice = businessLogic.calculateTotalOrderPrice(pasta, sauces);
		oderResponse.setPrice(totalPrice);
		RecipeResponse recipeResponse = businessLogic.getRecipeResponse(pasta,sauces);
		
		oderResponse = buildOrderResponseFromRecipeResponse(oderResponse,recipeResponse);
		logger.info("This the the order Response result:" + oderResponse);
		
		return oderResponse;

	}
	
	
	private OrderResponse buildOrderResponseFromRecipeResponse(OrderResponse oderResponse,
			RecipeResponse recipeResponse) {
		
		oderResponse.setImage(recipeResponse.getImage_url());
		oderResponse.setIngredients(recipeResponse.getIngredients());
		return oderResponse;
	}


}
