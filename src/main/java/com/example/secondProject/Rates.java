package com.example.secondProject;

import java.util.HashMap;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author ondrej.hosek
 */

@Data
public class Rates {

	@JsonProperty("last_updated")
	private String last_updated;

	@JsonProperty("disclaimer")
	private String disclaimer;

	@JsonProperty("rates")
	private HashMap<String, Country> countries;

}