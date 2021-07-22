package com.example.secondProject;

import java.io.IOException;

import javax.net.ssl.HttpsURLConnection;

import com.example.secondProject.Utils.CountryUtils;
import com.example.secondProject.Utils.RatesUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecondProjectApplication {
	public static Integer COUNTRY_COUNT = 3;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SecondProjectApplication.class, args);

		CountryUtils countryUtils = new CountryUtils();
		RatesUtil ratesUtil = new RatesUtil();

		Connector connector = new Connector();
		HttpsURLConnection connection = connector.createConnection();
		String jsonNode = connector.readData(connection);

		ObjectMapper mapper = new ObjectMapper();
		Rates rates = mapper.readValue(jsonNode, Rates.class);

		countryUtils.printListValues(ratesUtil.getEntriesMaxStdRate(rates), COUNTRY_COUNT);
		countryUtils.printListValues(ratesUtil.getEntriesMinStdRate(rates), COUNTRY_COUNT);

		countryUtils.writeToFile(ratesUtil.getEntriesMaxStdRate(rates), "MaxStdRates", COUNTRY_COUNT);
		countryUtils.writeToFile(ratesUtil.getEntriesMinStdRate(rates), "MinStdRates", COUNTRY_COUNT);
	}

}
