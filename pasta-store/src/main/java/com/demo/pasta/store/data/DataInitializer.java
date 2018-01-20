package com.demo.pasta.store.data;

import java.util.ArrayList;
import java.util.List;

import com.demo.pasta.store.data.entity.Cook;
import com.demo.pasta.store.data.entity.Pasta;
import com.demo.pasta.store.data.entity.Sauce;

public class DataInitializer {

	private static final String SPAGHETTI = "Spaghetti";
	public static final String FARFALLE = "Farfalle";
	public static final String LASAGNA = "Lasagna";
	public static final String FETTUCCINE = "Fettuccine";

	private static final String TOMATO = "Tomato";
	private static final String CREAM_CHEESE = "Cream cheese";
	public static final String BOLOGNESE = "Bolognese";
	private static final String PESTO = "Pesto";
	public static final String ALFREDO = "Alfredo";

	private static final String DEFAULT = "Default";
	public static final String FILLING = "Filling";
	public static final String OVEN = "Oven";

	List<Pasta> pastas = new ArrayList<Pasta>();
	List<Sauce> sauces = new ArrayList<Sauce>();
	List<Cook> cookes = new ArrayList<Cook>();

	// create an object of SingleObject
	private static DataInitializer instance = new DataInitializer();

	// Get the only object available
	public static DataInitializer getInstance() {
		return instance;
	}

	// make the constructor private so that this class cannot be
	// instantiated
	private DataInitializer() {
		setPastas();
		setSauces();
		setCook();

	}

	public List<Pasta> getPastas() {
		return pastas;
	}

	public List<Sauce> getSauces() {
		return sauces;
	}

	private void setPastas() {

		createSpaghetti();
		createFarfalle();
		createLasagna();
		createFettuccine();

	}

	private void createSpaghetti() {
		List<String> sauces = new ArrayList<String>();
		sauces.add(TOMATO);
		sauces.add(CREAM_CHEESE);
		sauces.add(PESTO);
		List<String> cooks = new ArrayList<String>();
		cooks.add(DEFAULT);
		pastas.add(new Pasta(SPAGHETTI, sauces, cooks, 15.99));
	}

	private void createFarfalle() {
		List<String> sauces = new ArrayList<String>();
		sauces.add(PESTO);
		sauces.add(ALFREDO);
		List<String> cooks = new ArrayList<String>();
		cooks.add(OVEN);
		cooks.add(DataInitializer.FILLING);
		pastas.add(new Pasta(FARFALLE, sauces, cooks, 14.99));
	}

	private void createLasagna() {
		List<String> sauces = new ArrayList<String>();
		sauces.add(TOMATO);
		sauces.add(CREAM_CHEESE);
		sauces.add(PESTO);
		List<String> cooks = new ArrayList<String>();
		cooks.add(DEFAULT);
		pastas.add(new Pasta(DataInitializer.LASAGNA, sauces, cooks, 13.99));
	}

	private void createFettuccine() {
		List<String> sauces = new ArrayList<String>();
		sauces.add(TOMATO);
		sauces.add(CREAM_CHEESE);
		sauces.add(BOLOGNESE);
		List<String> cooks = new ArrayList<String>();
		cooks.add(DEFAULT);
		pastas.add(new Pasta(FETTUCCINE, sauces, cooks, 12.99));
	}

	private void setSauces() {
		createTomato();
		createCreamCheese();
		createPesto();
		createAlfredo();
		createBolognese();
	}

	private void createTomato() {
		this.sauces.add(new Sauce(TOMATO, 3.99));
	}

	private void createCreamCheese() {
		this.sauces.add(new Sauce(CREAM_CHEESE, 3.99));
	}

	private void createPesto() {
		this.sauces.add(new Sauce(PESTO, 2.99));
	}

	private void createAlfredo() {
		this.sauces.add(new Sauce(ALFREDO, 3.99));
	}

	private void createBolognese() {
		this.sauces.add(new Sauce(DataInitializer.BOLOGNESE, 5.99));
	}

	private void setCook() {
		createDefault();
		createOven();
		createFilling();
	}

	private void createDefault() {
		this.cookes.add(new Cook(DEFAULT, "Boil 9 minutes"));

	}

	private void createOven() {
		this.cookes.add(new Cook(DataInitializer.OVEN, "This item needs to be in the oven"));

	}

	private void createFilling() {
		this.cookes.add(new Cook(DataInitializer.FILLING, "This item needs to be filled"));

	}

}
