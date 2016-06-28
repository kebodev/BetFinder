/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kebo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabor_dev
 */
@Entity
@Table(name = "TIPBET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipbet.findAll", query = "SELECT t FROM Tipbet t"),
    @NamedQuery(name = "Tipbet.findById", query = "SELECT t FROM Tipbet t WHERE t.id = :id"),
    @NamedQuery(name = "Tipbet.findByEventId", query = "SELECT t FROM Tipbet t WHERE t.eventId = :eventId"),
    @NamedQuery(name = "Tipbet.findByPlayerTeams", query = "SELECT t FROM Tipbet t WHERE t.playerTeams = :playerTeams"),
    @NamedQuery(name = "Tipbet.findByEventDate", query = "SELECT t FROM Tipbet t WHERE t.eventDate = :eventDate"),
    @NamedQuery(name = "Tipbet.findByMarketTypeId", query = "SELECT t FROM Tipbet t WHERE t.marketTypeId = :marketTypeId"),
    @NamedQuery(name = "Tipbet.findByMarketIndicate", query = "SELECT t FROM Tipbet t WHERE t.marketIndicate = :marketIndicate"),
    @NamedQuery(name = "Tipbet.findByOddsValue", query = "SELECT t FROM Tipbet t WHERE t.oddsValue = :oddsValue"),
    @NamedQuery(name = "Tipbet.findByWhoWon", query = "SELECT t FROM Tipbet t WHERE t.whoWon = :whoWon"),
    @NamedQuery(name = "Tipbet.findByBookmakerId", query = "SELECT t FROM Tipbet t WHERE t.bookmakerId = :bookmakerId")})
public class Tipbet implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    //@NotNull
    @GeneratedValue(generator="TIPBET_ID")
    @SequenceGenerator(name="TIPBET_ID",sequenceName="RAKTAR_MAIN_SEQ", allocationSize=1)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "EVENT_ID")
    private BigInteger eventId;
    @Size(max = 100)
    @Column(name = "PLAYER_TEAMS")
    private String playerTeams;
    @Column(name = "EVENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDate;
    @Column(name = "MARKET_TYPE_ID")
    private BigInteger marketTypeId;
    @Size(max = 100)
    @Column(name = "MARKET_INDICATE")
    private String marketIndicate;
    @Column(name = "ODDS_VALUE")
    private BigDecimal oddsValue;
    @Column(name = "WHO_WON")
    private String whoWon;
    @Column(name = "BOOKMAKER_ID")
    private BigInteger bookmakerId;

    public Tipbet() {
    }

    public Tipbet(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getEventId() {
        return eventId;
    }

    public void setEventId(BigInteger eventId) {
        this.eventId = eventId;
    }

    public String getPlayerTeams() {
        return playerTeams;
    }

    public void setPlayerTeams(String playerTeams) {
        this.playerTeams = playerTeams;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public BigInteger getMarketTypeId() {
        return marketTypeId;
    }

    public void setMarketTypeId(BigInteger marketTypeId) {
        this.marketTypeId = marketTypeId;
    }

    public String getMarketIndicate() {
        return marketIndicate;
    }

    public void setMarketIndicate(String marketIndicate) {
        this.marketIndicate = marketIndicate;
    }

    public BigDecimal getOddsValue() {
        return oddsValue;
    }

    public void setOddsValue(BigDecimal oddsValue) {
        this.oddsValue = oddsValue;
    }

    public String getWhoWon() {
        return whoWon;
    }

    public void setWhoWon(String whoWon) {
        this.whoWon = whoWon;
    }

    public BigInteger getBookmakerId() {
        return bookmakerId;
    }

    public void setBookmakerId(BigInteger bookmakerId) {
        this.bookmakerId = bookmakerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipbet)) {
            return false;
        }
        Tipbet other = (Tipbet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kebo.entity.Tipbet[ id=" + id + " ]";
    }
    
}
