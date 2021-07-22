package com.example.secondProject;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecondProjectApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SecondProjectApplication.class, args);

		CountryUtils countryUtils = new CountryUtils();


		Connector connector = new Connector();
		HttpsURLConnection connection = connector.createConnection();
		String jsonNode = connector.readData(connection);
		System.out.println(jsonNode);


		ObjectMapper mapper = new ObjectMapper();
		Rates rates = mapper.readValue(jsonNode, Rates.class);


		//	4. vyhledávání - vyhledam 3 země s nejvyšší a 3 s nejnižší


		;
		maxEntries(rates);

		countryUtils.printValues((HashMap<String, Country>) maxEntries(rates));
	}

	protected static List<Map.Entry<String, Country>> maxEntries(final Rates rates) {
		List<Map.Entry<String, Country>> maxRates = rates.getCountries()
				.entrySet()
				.stream()
				.sorted(Comparator.comparing(o -> o.getValue().getStandardRate(), Comparator.reverseOrder()))
				.collect(Collectors.toList());
		return maxRates;
	}

	protected static List minRates(final Rates rates) {
		List<Map.Entry<String, Country>> minRates = rates.getCountries()
				.entrySet()
				.stream()
				.sorted(Comparator.comparing(o -> o.getValue().getStandardRate()))
				.collect(Collectors.toList());
		return minRates;
	}


//	interaktivni prikazove radky - zadam zkratku zeme
//	zapisu vysledek do souboru - jenom to co je v te radce - string do souboru
//	api na GET podle kodu...


}
