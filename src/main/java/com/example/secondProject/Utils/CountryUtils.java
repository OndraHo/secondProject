package com.example.secondProject.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.example.secondProject.Country;

/**
 * @author ondrej.hosek
 */

public class CountryUtils {

	private static String COUNTRY_INFO_DELIMITER = "####################";

	public void printListValues(final List<Map.Entry<String, Country>> countryList, final Integer countryCount) {
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

	public void writeToFile(final List<Map.Entry<String, Country>> countryList, final String fileName, final Integer countryCount) {
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