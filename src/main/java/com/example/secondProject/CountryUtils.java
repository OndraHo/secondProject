package com.example.secondProject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ondrej.hosek
 */

public class CountryUtils {

	private static String COUNTRY_INFO_DELIMITER = "COUNTRY_INFO_DELIMITER";


	//	5 Vypsat hodnoty pomocí interaktivní příkazové řádky
	protected void printValues(HashMap<String, Country> countryList) {
		for (Map.Entry<String, Country> country : countryList.entrySet()) {
			System.out.println(country.getKey() + " " + country.getValue().getStandardRate());
		}
	}

//	6 Umožnit zapsat výsledek do souboru
	protected void writeToFile(HashMap<String, Country> countryList) {
		try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("countries_list.txt")))) {
			for (Map.Entry<String, Country> country : countryList.entrySet()) {
				printWriter.println(country.getKey());
				printWriter.println(country.getValue().getCountry());
				printWriter.println(COUNTRY_INFO_DELIMITER);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} ;
	}

}