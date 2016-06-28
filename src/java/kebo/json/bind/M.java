
package kebo.json.bind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "K",
    "I",
    "H",
    "B"
})
public class M {

    @JsonProperty("K")
    private String k;
    @JsonProperty("I")
    private Integer i;
    @JsonProperty("H")
    private String h;
    @JsonProperty("B")
    private List<B> b = new ArrayList<B>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The k
     */
    @JsonProperty("K")
    public String getK() {
        return k;
    }

    /**
     * 
     * @param k
     *     The K
     */
    @JsonProperty("K")
    public void setK(String k) {
        this.k = k;
    }

    /**
     * 
     * @return
     *     The i
     */
    @JsonProperty("I")
    public Integer getI() {
        return i;
    }

    /**
     * 
     * @param i
     *     The I
     */
    @JsonProperty("I")
    public void setI(Integer i) {
        this.i = i;
    }

    /**
     * 
     * @return
     *     The h
     */
    @JsonProperty("H")
    public String getH() {
        return h;
    }

    /**
     * 
     * @param h
     *     The H
     */
    @JsonProperty("H")
    public void setH(String h) {
        this.h = h;
    }

    /**
     * 
     * @return
     *     The b
     */
    @JsonProperty("B")
    public List<B> getB() {
        return b;
    }

    /**
     * 
     * @param b
     *     The B
     */
    @JsonProperty("B")
    public void setB(List<B> b) {
        this.b = b;
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
