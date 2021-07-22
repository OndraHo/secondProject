package com.example.secondProject;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author ondrej.hosek
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country implements Comparable<Country> {

	@JsonProperty("country")
	private String country;

	@JsonProperty("_comment")
	private String comment;

	@JsonProperty("iso_duplicate")
	private String isoDuplicate;

	@JsonProperty("standard_rate")
	private BigDecimal standardRate; // string?

	@JsonProperty("reduced_rate")
	private String reducedRate;

	@JsonProperty("reduced_rate_alt")
	private String reducedRateAlt;

	@JsonProperty("super_reduced_rate")
	private String superReducedRate;

	@JsonProperty("parking_rate")
	private String parkingRate;

	@JsonProperty("iso_duplicate_of")
	private String isoDuplicateOf;


	@Override
	public int compareTo(final Country o) {
		return 0;
	}
}