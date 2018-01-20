package com.demo.pasta.store;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pasta.store.data.DataInitializer;
import com.demo.pasta.store.data.entity.Pasta;
import com.demo.pasta.store.data.entity.Sauce;
import com.demo.pasta.store.exception.PastaNotFoundException;
import com.demo.pasta.store.model.PastaResponse;
import com.demo.pasta.store.model.PastaResponseHolder;
import com.demo.pasta.store.model.SauceResponse;

@RestController
public class PastaController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final AtomicLong counter = new AtomicLong();

	DataInitializer data = DataInitializer.getInstance();

	@RequestMapping("/pasta")
	public PastaResponseHolder getPasta() {

		logger.debug("This is a debug message from /pasta");
		return new PastaResponseHolder(counter.incrementAndGet(), buildPastaResponseHolder());
	}
	
	@RequestMapping(value = "/pasta/{name}")
	public PastaResponse getPastaByName(@PathVariable("name") String name) {
		logger.debug("This is a debug message from getPastaByName with input:" + name);
		return new PastaResponse(counter.incrementAndGet(), buildPastaResponse(name));
	}
	

	@RequestMapping("/sauce")
	public SauceResponse getSauce() {

		logger.debug("This is a debug message from /sauce");
		return new SauceResponse(counter.incrementAndGet(), buildSauceRespose());

	}
	
	private Pasta buildPastaResponse(String name) {
		
		if(name==null) return null;
		for (Pasta pasta : data.getPastas()) {
			if(name.equals(pasta.getName())){
				return pasta;
			}
		}
		
		throw new PastaNotFoundException("Can't find pasta name:" + name);
		
	}

	private List<String> buildPastaResponseHolder() {
		List<String> pastas = new ArrayList<String>();

		for (Pasta pasta : data.getPastas()) {
			pastas.add(pasta.getName());
		}
		return pastas;
	}

	private List<String> buildSauceRespose() {

		List<String> sauces = new ArrayList<String>();

		for (Sauce sauce : data.getSauces()) {
			sauces.add(sauce.getName());
		}
		return sauces;
	}

}
