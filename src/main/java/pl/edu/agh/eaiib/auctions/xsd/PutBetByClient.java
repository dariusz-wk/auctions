
package pl.edu.agh.eaiib.auctions.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PutBetByClient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PutBetByClient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClientLogin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AuctionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Bet" type="{http://eaiib.agh.edu.pl/auctions/xsd/}BetType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PutBetByClient", propOrder = {
    "clientLogin",
    "auctionId",
    "bet"
})
public class PutBetByClient {

    @XmlElement(name = "ClientLogin", required = true)
    protected String clientLogin;
    @XmlElement(name = "AuctionId", required = true)
    protected String auctionId;
    @XmlElement(name = "Bet", required = true)
    protected BetType bet;

    /**
     * Gets the value of the clientLogin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientLogin() {
        return clientLogin;
    }

    /**
     * Sets the value of the clientLogin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientLogin(String value) {
        this.clientLogin = value;
    }

    /**
     * Gets the value of the auctionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuctionId() {
        return auctionId;
    }

    /**
     * Sets the value of the auctionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuctionId(String value) {
        this.auctionId = value;
    }

    /**
     * Gets the value of the bet property.
     * 
     * @return
     *     possible object is
     *     {@link BetType }
     *     
     */
    public BetType getBet() {
        return bet;
    }

    /**
     * Sets the value of the bet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BetType }
     *     
     */
    public void setBet(BetType value) {
        this.bet = value;
    }

}
