package com.example.secondProject;

import java.io.IOException;
import java.math.BigDecimal;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.std.StdDeserializer;

/**
 * @author ondrej.hosek
 */

public class CountryDeserializer {

	public CountryDeserializer() {
		this(null);
	}
	public CountryDeserializer(Class<Country> vc){

	}



	public Country deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
		JsonNode node =jsonParser.getCodec().readTree(jsonParser);

//		String countryCode = node.get("country_code")
		String countryName = node.get("rates").get("country").asText();
		String comment = node.get("_comment").asText();
		String isoDuplicateOf = node.get("iso_duplicate").asText();
		BigDecimal standardRate = new BigDecimal(node.get("standard_rate").asInt());
		BigDecimal reducedRate = new BigDecimal(node.get("reduced_rate").asInt());
		BigDecimal reducedRateAlt = new BigDecimal(node.get("reduced_rate_alt").asInt());
		BigDecimal superReducedRate = new BigDecimal(node.get("super_reduced_rate").asInt());
		Boolean parkingRate = node.get("parking_rate").asBoolean();

//		return new Country("", countryName, comment, isoDuplicateOf, standardRate, reducedRate, reducedRateAlt, superReducedRate, parkingRate);
		return null;
	}
}