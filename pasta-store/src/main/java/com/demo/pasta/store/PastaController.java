package com.demo.pasta.store;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pasta.store.business.BusinessLogic;
import com.demo.pasta.store.data.entity.Pasta;
import com.demo.pasta.store.model.PastaResponse;
import com.demo.pasta.store.model.PastaResponseHolder;
import com.demo.pasta.store.model.SauceResponse;
import com.demo.pasta.store.util.PastaUtils;

@RestController
public class PastaController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired	
	BusinessLogic bl;

	@RequestMapping("/pasta")
	public PastaResponseHolder getPasta() {

		logger.debug("This is a debug message from /pasta");
		return new PastaResponseHolder(counter.incrementAndGet(), buildPastaList());
	}
	
	@RequestMapping(value = "/pasta/{name}")
	public PastaResponse getPastaByName(@PathVariable("name") String name) {
		logger.debug("This is a debug message from getPastaByName with input:" + name);
		return new PastaResponse(counter.incrementAndGet(), buildPasta(name));
	}
	

	@RequestMapping("/sauce")
	public SauceResponse getSauce() {

		logger.debug("This is a debug message from /sauce");
		return new SauceResponse(counter.incrementAndGet(), buildSauceList());

	}
	
	private Pasta buildPasta(String name) {
		
		PastaUtils.validateStringIsNotNullOrEmpty(name);
		return bl.getPastaByName(name);
		
	}

	private List<String> buildPastaList() {
		
		List<String> pastas = bl.getAllPastaNames();
		return pastas;
	}

	private List<String> buildSauceList() {
		
		List<String> sauces = bl.getAllSaucesNames();
		return sauces;
	}

}
