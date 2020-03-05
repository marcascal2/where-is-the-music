package aiss.model.ticketmaster;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class EventEmbedded {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "venues", "attractions" })

	@JsonProperty("venues")
	private List<Venue> venues = null;
	@JsonProperty("attractions")
	private List<Attraction_> attractions = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("venues")
	public List<Venue> getVenues() {
		return venues;
	}

	@JsonProperty("venues")
	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}

	@JsonProperty("attractions")
	public List<Attraction_> getAttractions() {
		return attractions;
	}

	@JsonProperty("attractions")
	public void setAttractions(List<Attraction_> attractions) {
		this.attractions = attractions;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}