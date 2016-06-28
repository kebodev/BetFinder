
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
    "D",
    "CNT",
    "S"
})
public class BettingBaseJSON {

    @JsonProperty("D")
    private Integer d;
    @JsonProperty("CNT")
    private Integer cNT;
    @JsonProperty("S")
    private List<S> s = new ArrayList<S>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The d
     */
    @JsonProperty("D")
    public Integer getD() {
        return d;
    }

    /**
     * 
     * @param d
     *     The D
     */
    @JsonProperty("D")
    public void setD(Integer d) {
        this.d = d;
    }

    /**
     * 
     * @return
     *     The cNT
     */
    @JsonProperty("CNT")
    public Integer getCNT() {
        return cNT;
    }

    /**
     * 
     * @param cNT
     *     The CNT
     */
    @JsonProperty("CNT")
    public void setCNT(Integer cNT) {
        this.cNT = cNT;
    }

    /**
     * 
     * @return
     *     The s
     */
    @JsonProperty("S")
    public List<S> getS() {
        return s;
    }

    /**
     * 
     * @param s
     *     The S
     */
    @JsonProperty("S")
    public void setS(List<S> s) {
        this.s = s;
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
