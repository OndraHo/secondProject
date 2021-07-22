package com.example.secondProject;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecondProjectApplication {
	public static Integer COUNTRY_COUNT = 3;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SecondProjectApplication.class, args);

		CountryUtils countryUtils = new CountryUtils();

		Connector connector = new Connector();
		HttpsURLConnection connection = connector.createConnection();
		String jsonNode = connector.readData(connection);
		System.out.println(jsonNode);

		ObjectMapper mapper = new ObjectMapper();
		Rates rates = mapper.readValue(jsonNode, Rates.class);


		countryUtils.printListValues(getEntriesMaxStdRate(rates), COUNTRY_COUNT);
		countryUtils.printListValues(getEntriesMinStdRate(rates), COUNTRY_COUNT);

		countryUtils.writeToFile(getEntriesMaxStdRate(rates), "MaxStdRates", COUNTRY_COUNT);
		countryUtils.writeToFile(getEntriesMinStdRate(rates), "MinStdRates", COUNTRY_COUNT);
	}

	protected static List<Map.Entry<String, Country>> getEntriesMaxStdRate(final Rates rates) {
		List<Map.Entry<String, Country>> maxRates = rates.getCountries()
				.entrySet()
				.stream()
				.sorted(Comparator.comparing(o -> o.getValue().getStandardRate(), Comparator.reverseOrder()))
				.collect(Collectors.toList());
		return maxRates;
	}

	protected static List<Map.Entry<String, Country>> getEntriesMinStdRate(final Rates rates) {
		List<Map.Entry<String, Country>> maxRates = rates.getCountries()
				.entrySet()
				.stream()
				.sorted(Comparator.comparing(o -> o.getValue().getStandardRate()))
				.collect(Collectors.toList());
		return maxRates;
	}

}
