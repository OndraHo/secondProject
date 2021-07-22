package com.example.secondProject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ondrej.hosek
 */

public class CountryUtils {

	private static String COUNTRY_INFO_DELIMITER = "####################";

	protected void printListValues(final List<Map.Entry<String, Country>> countryList, final Integer countryCount) {
		int i = 1;
		//		for (int i = 0; i < countryCount; i++) {
		for (Map.Entry<String, Country> country : countryList) {
			System.out.println(country.getKey() + " " + country.getValue().getStandardRate());
			i++;
			if (countryCount < i){
				return;
			}
		}
	}

	protected void writeToFile(final List<Map.Entry<String, Country>> countryList, final String fileName, final Integer countryCount) {
		try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
			int i = 1;
			for (Map.Entry<String, Country> country : countryList) {
				printWriter.println(country.getKey());
				printWriter.println(country.getValue().getCountry());
				printWriter.println("Standard rate is " + country.getValue().getStandardRate());
				printWriter.println(COUNTRY_INFO_DELIMITER);
				i++;
				if (countryCount < i){
					return;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}