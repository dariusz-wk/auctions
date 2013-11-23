
package pl.edu.agh.eaiib.auctions.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PutAuctionByManagerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PutAuctionByManagerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Auction" type="{http://eaiib.agh.edu.pl/auctions/xsd/}AuctionType"/>
 *         &lt;element name="AMLogin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PutAuctionByManagerResponse", propOrder = {
    "auction",
    "amLogin"
})
public class PutAuctionByManagerResponse {

    @XmlElement(name = "Auction", required = true)
    protected AuctionType auction;
    @XmlElement(name = "AMLogin", required = true)
    protected String amLogin;

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

}
