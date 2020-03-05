
package aiss.model.youtube;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "default",
    "medium",
    "high"
})
public class Thumbnails {

    @JsonProperty("default")
    private Default _default;
    @JsonProperty("medium")
    private Medium medium;
    @JsonProperty("high")
    private High high;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("default")
    public Default getDefault() {
        return _default;
    }

    @JsonProperty("default")
    public void setDefault(Default _default) {
        this._default = _default;
    }

    @JsonProperty("medium")
    public Medium getMedium() {
        return medium;
    }

    @JsonProperty("medium")
    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    @JsonProperty("high")
    public High getHigh() {
        return high;
    }

    @JsonProperty("high")
    public void setHigh(High high) {
        this.high = high;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_default == null) ? 0 : _default.hashCode());
		result = prime * result + ((additionalProperties == null) ? 0 : additionalProperties.hashCode());
		result = prime * result + ((high == null) ? 0 : high.hashCode());
		result = prime * result + ((medium == null) ? 0 : medium.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thumbnails other = (Thumbnails) obj;
		if (_default == null) {
			if (other._default != null)
				return false;
		} else if (!_default.equals(other._default))
			return false;
		if (additionalProperties == null) {
			if (other.additionalProperties != null)
				return false;
		} else if (!additionalProperties.equals(other.additionalProperties))
			return false;
		if (high == null) {
			if (other.high != null)
				return false;
		} else if (!high.equals(other.high))
			return false;
		if (medium == null) {
			if (other.medium != null)
				return false;
		} else if (!medium.equals(other.medium))
			return false;
		return true;
	}

    

}
