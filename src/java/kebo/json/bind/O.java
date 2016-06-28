
package kebo.json.bind;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "N",
    "V",
    "LYV"
})
public class O {

    @JsonProperty("N")
    private String n;
    @JsonProperty("V")
    private Double v;
    @JsonProperty("LYV")
    private Double lYV;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The n
     */
    @JsonProperty("N")
    public String getN() {
        return n;
    }

    /**
     * 
     * @param n
     *     The N
     */
    @JsonProperty("N")
    public void setN(String n) {
        this.n = n;
    }

    /**
     * 
     * @return
     *     The v
     */
    @JsonProperty("V")
    public Double getV() {
        return v;
    }

    /**
     * 
     * @param v
     *     The V
     */
    @JsonProperty("V")
    public void setV(Double v) {
        this.v = v;
    }

    /**
     * 
     * @return
     *     The lYV
     */
    @JsonProperty("LYV")
    public Double getLYV() {
        return lYV;
    }

    /**
     * 
     * @param lYV
     *     The LYV
     */
    @JsonProperty("LYV")
    public void setLYV(Double lYV) {
        this.lYV = lYV;
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
