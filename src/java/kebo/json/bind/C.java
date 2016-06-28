
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
    "L"
})
public class C {

    @JsonProperty("I")
    private Integer i;
    @JsonProperty("N")
    private String n;
    @JsonProperty("L")
    private List<L> l = new ArrayList<L>();
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
     *     The l
     */
    @JsonProperty("L")
    public List<L> getL() {
        return l;
    }

    /**
     * 
     * @param l
     *     The L
     */
    @JsonProperty("L")
    public void setL(List<L> l) {
        this.l = l;
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
