package com.example.secondProject.Utils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.secondProject.Country;
import com.example.secondProject.Rates;

/**
 * @author ondrej.hosek
 */

public class RatesUtil {

	public static List<Map.Entry<String, Country>> getEntriesMaxStdRate(final Rates rates) {
		List<Map.Entry<String, Country>> maxRates = rates.getCountries()
				.entrySet()
				.stream()
				.sorted(Comparator.comparing(o -> o.getValue().getStandardRate(), Comparator.reverseOrder()))
				.collect(Collectors.toList());
		return maxRates;
	}

	public static List<Map.Entry<String, Country>> getEntriesMinStdRate(final Rates rates) {
		List<Map.Entry<String, Country>> maxRates = rates.getCountries()
				.entrySet()
				.stream()
				.sorted(Comparator.comparing(o -> o.getValue().getStandardRate()))
				.collect(Collectors.toList());
		return maxRates;
	}
}