
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
    "I",
    "N",
    "C"
})
public class S {

    @JsonProperty("I")
    private Integer i;
    @JsonProperty("N")
    private String n;
    @JsonProperty("C")
    private List<C> c = new ArrayList<C>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The c
     */
    @JsonProperty("C")
    public List<C> getC() {
        return c;
    }

    /**
     * 
     * @param c
     *     The C
     */
    @JsonProperty("C")
    public void setC(List<C> c) {
        this.c = c;
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
