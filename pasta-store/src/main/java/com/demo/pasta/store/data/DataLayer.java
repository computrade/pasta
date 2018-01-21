package com.demo.pasta.store.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.pasta.store.data.entity.Pasta;
import com.demo.pasta.store.data.entity.Sauce;
import com.demo.pasta.store.exception.PastaNotFoundException;
import com.demo.pasta.store.exception.SauceNotFoundException;

@Service
public class DataLayer {

	DataInitializer data = DataInitializer.getInstance();
	
		
	public List<String>	getAllPastaNames(){
		
		List<String> pastas = new ArrayList<String>();
		
		for (Pasta pasta : data.getPastas()) {
			pastas.add(pasta.getName());
		}
		return pastas;
	}
	
	
	public List<String> getAllSaucesNames() {

		List<String> sauces = new ArrayList<String>();

		for (Sauce sauce : data.getSauces()) {
			sauces.add(sauce.getName());
		}
		return sauces;
	}
	
	public Pasta getPastaByName(String iPasta) {

		for (Pasta pasta : data.getPastas()) {
			if (iPasta.equals(pasta.getName())) {
				return pasta;
			}
		}

		throw new PastaNotFoundException("Can't find pasta name:" + iPasta);
	}

	public Sauce getSauceByName(String iSauce) {

		for (Sauce sauce : data.getSauces()) {
			if (iSauce.equals(sauce.getName())) {
				return sauce;
			}
		}

		throw new SauceNotFoundException("Can't find sauce name:" + iSauce);
	}

}
