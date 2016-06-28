
package kebo.json.bind;

import java.math.BigInteger;
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
    "DT",
    "ISH",
    "BKS",
    "T1",
    "T2",
    "T1I",
    "T2I",
    "SC",
    "SCE",
    "PR",
    "MN",
    "A",
    "M"
})
public class E {

    @JsonProperty("I")
    private Integer i;
    @JsonProperty("DT")
    private BigInteger dT;
    @JsonProperty("ISH")
    private Integer iSH;
    @JsonProperty("BKS")
    private Integer bKS;
    @JsonProperty("T1")
    private String t1;
    @JsonProperty("T2")
    private String t2;
    @JsonProperty("T1I")
    private Integer t1I;
    @JsonProperty("T2I")
    private Integer t2I;
    @JsonProperty("SC")
    private String sC;
    @JsonProperty("SCE")
    private String sCE;
    @JsonProperty("PR")
    private Integer pR;
    @JsonProperty("MN")
    private Double mN;
    @JsonProperty("A")
    private Integer a;
    @JsonProperty("M")
    private List<M> m = new ArrayList<M>();
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
     *     The dT
     */
    @JsonProperty("DT")
    public BigInteger getDT() {
        return dT;
    }

    /**
     * 
     * @param dT
     *     The DT
     */
    @JsonProperty("DT")
    public void setDT(BigInteger dT) {
        this.dT = dT;
    }

    /**
     * 
     * @return
     *     The iSH
     */
    @JsonProperty("ISH")
    public Integer getISH() {
        return iSH;
    }

    /**
     * 
     * @param iSH
     *     The ISH
     */
    @JsonProperty("ISH")
    public void setISH(Integer iSH) {
        this.iSH = iSH;
    }

    /**
     * 
     * @return
     *     The bKS
     */
    @JsonProperty("BKS")
    public Integer getBKS() {
        return bKS;
    }

    /**
     * 
     * @param bKS
     *     The BKS
     */
    @JsonProperty("BKS")
    public void setBKS(Integer bKS) {
        this.bKS = bKS;
    }

    /**
     * 
     * @return
     *     The t1
     */
    @JsonProperty("T1")
    public String getT1() {
        return t1;
    }

    /**
     * 
     * @param t1
     *     The T1
     */
    @JsonProperty("T1")
    public void setT1(String t1) {
        this.t1 = t1;
    }

    /**
     * 
     * @return
     *     The t2
     */
    @JsonProperty("T2")
    public String getT2() {
        return t2;
    }

    /**
     * 
     * @param t2
     *     The T2
     */
    @JsonProperty("T2")
    public void setT2(String t2) {
        this.t2 = t2;
    }

    /**
     * 
     * @return
     *     The t1I
     */
    @JsonProperty("T1I")
    public Integer getT1I() {
        return t1I;
    }

    /**
     * 
     * @param t1I
     *     The T1I
     */
    @JsonProperty("T1I")
    public void setT1I(Integer t1I) {
        this.t1I = t1I;
    }

    /**
     * 
     * @return
     *     The t2I
     */
    @JsonProperty("T2I")
    public Integer getT2I() {
        return t2I;
    }

    /**
     * 
     * @param t2I
     *     The T2I
     */
    @JsonProperty("T2I")
    public void setT2I(Integer t2I) {
        this.t2I = t2I;
    }

    /**
     * 
     * @return
     *     The sC
     */
    @JsonProperty("SC")
    public String getSC() {
        return sC;
    }

    /**
     * 
     * @param sC
     *     The SC
     */
    @JsonProperty("SC")
    public void setSC(String sC) {
        this.sC = sC;
    }

    /**
     * 
     * @return
     *     The sCE
     */
    @JsonProperty("SCE")
    public String getSCE() {
        return sCE;
    }

    /**
     * 
     * @param sCE
     *     The SCE
     */
    @JsonProperty("SCE")
    public void setSCE(String sCE) {
        this.sCE = sCE;
    }

    /**
     * 
     * @return
     *     The pR
     */
    @JsonProperty("PR")
    public Integer getPR() {
        return pR;
    }

    /**
     * 
     * @param pR
     *     The PR
     */
    @JsonProperty("PR")
    public void setPR(Integer pR) {
        this.pR = pR;
    }

    /**
     * 
     * @return
     *     The mN
     */
    @JsonProperty("MN")
    public Double getMN() {
        return mN;
    }

    /**
     * 
     * @param mN
     *     The MN
     */
    @JsonProperty("MN")
    public void setMN(Double mN) {
        this.mN = mN;
    }

    /**
     * 
     * @return
     *     The a
     */
    @JsonProperty("A")
    public Integer getA() {
        return a;
    }

    /**
     * 
     * @param a
     *     The A
     */
    @JsonProperty("A")
    public void setA(Integer a) {
        this.a = a;
    }

    /**
     * 
     * @return
     *     The m
     */
    @JsonProperty("M")
    public List<M> getM() {
        return m;
    }

    /**
     * 
     * @param m
     *     The M
     */
    @JsonProperty("M")
    public void setM(List<M> m) {
        this.m = m;
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
