
package pl.edu.agh.eaiib.auctions.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetAuctionsForClient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAuctionsForClient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClientLogin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AuctionListFilter" type="{http://eaiib.agh.edu.pl/auctions/xsd/}AuctionListFilterType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAuctionsForClient", propOrder = {
    "clientLogin",
    "auctionListFilter"
})
public class GetAuctionsForClient {

    @XmlElement(name = "ClientLogin", required = true)
    protected String clientLogin;
    @XmlElement(name = "AuctionListFilter")
    protected AuctionListFilterType auctionListFilter;

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
     * Gets the value of the auctionListFilter property.
     * 
     * @return
     *     possible object is
     *     {@link AuctionListFilterType }
     *     
     */
    public AuctionListFilterType getAuctionListFilter() {
        return auctionListFilter;
    }

    /**
     * Sets the value of the auctionListFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuctionListFilterType }
     *     
     */
    public void setAuctionListFilter(AuctionListFilterType value) {
        this.auctionListFilter = value;
    }

}
