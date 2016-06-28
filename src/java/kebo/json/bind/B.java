
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
    "BTDT",
    "O"
})
public class B {

    @JsonProperty("I")
    private Integer i;
    @JsonProperty("BTDT")
    private Integer bTDT;
    @JsonProperty("O")
    private List<O> o = new ArrayList<O>();
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
     *     The bTDT
     */
    @JsonProperty("BTDT")
    public Integer getBTDT() {
        return bTDT;
    }

    /**
     * 
     * @param bTDT
     *     The BTDT
     */
    @JsonProperty("BTDT")
    public void setBTDT(Integer bTDT) {
        this.bTDT = bTDT;
    }

    /**
     * 
     * @return
     *     The o
     */
    @JsonProperty("O")
    public List<O> getO() {
        return o;
    }

    /**
     * 
     * @param o
     *     The O
     */
    @JsonProperty("O")
    public void setO(List<O> o) {
        this.o = o;
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
