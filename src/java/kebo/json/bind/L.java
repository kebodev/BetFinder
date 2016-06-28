
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
    "E"
})
public class L {

    @JsonProperty("I")
    private Integer i;
    @JsonProperty("N")
    private String n;
    @JsonProperty("E")
    private List<E> e = new ArrayList<E>();
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
     *     The e
     */
    @JsonProperty("E")
    public List<E> getE() {
        return e;
    }

    /**
     * 
     * @param e
     *     The E
     */
    @JsonProperty("E")
    public void setE(List<E> e) {
        this.e = e;
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
