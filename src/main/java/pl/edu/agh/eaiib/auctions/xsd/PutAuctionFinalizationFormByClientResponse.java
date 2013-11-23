
package pl.edu.agh.eaiib.auctions.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PutAuctionFinalizationFormByClientResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PutAuctionFinalizationFormByClientResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AMLogin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClientLogin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AuctionManagerContactData" type="{http://eaiib.agh.edu.pl/auctions/xsd/}AuctionManagerContactDataType"/>
 *         &lt;element name="Auction" type="{http://eaiib.agh.edu.pl/auctions/xsd/}AuctionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PutAuctionFinalizationFormByClientResponse", propOrder = {
    "amLogin",
    "clientLogin",
    "auctionManagerContactData",
    "auction"
})
public class PutAuctionFinalizationFormByClientResponse {

    @XmlElement(name = "AMLogin", required = true)
    protected String amLogin;
    @XmlElement(name = "ClientLogin", required = true)
    protected String clientLogin;
    @XmlElement(name = "AuctionManagerContactData", required = true)
    protected AuctionManagerContactDataType auctionManagerContactData;
    @XmlElement(name = "Auction", required = true)
    protected AuctionType auction;

    /**
     * Gets the value of the amLogin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAMLogin() {
        return amLogin;
    }

    /**
     * Sets the value of the amLogin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAMLogin(String value) {
        this.amLogin = value;
    }

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
     * Gets the value of the auctionManagerContactData property.
     * 
     * @return
     *     possible object is
     *     {@link AuctionManagerContactDataType }
     *     
     */
    public AuctionManagerContactDataType getAuctionManagerContactData() {
        return auctionManagerContactData;
    }

    /**
     * Sets the value of the auctionManagerContactData property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuctionManagerContactDataType }
     *     
     */
    public void setAuctionManagerContactData(AuctionManagerContactDataType value) {
        this.auctionManagerContactData = value;
    }

    /**
     * Gets the value of the auction property.
     * 
     * @return
     *     possible object is
     *     {@link AuctionType }
     *     
     */
    public AuctionType getAuction() {
        return auction;
    }

    /**
     * Sets the value of the auction property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuctionType }
     *     
     */
    public void setAuction(AuctionType value) {
        this.auction = value;
    }

}
