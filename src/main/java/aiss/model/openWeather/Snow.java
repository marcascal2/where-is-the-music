
package aiss.model.openWeather;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "3h"
})
public class Snow {

    @JsonProperty("3h")
    private Double _3h;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Snow() {
    }

    /**
     * 
     * @param _3h
     */
    public Snow(Double _3h) {
        super();
        this._3h = _3h;
    }

    @JsonProperty("3h")
    public Double get3h() {
        return _3h;
    }

    @JsonProperty("3h")
    public void set3h(Double _3h) {
        this._3h = _3h;
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
