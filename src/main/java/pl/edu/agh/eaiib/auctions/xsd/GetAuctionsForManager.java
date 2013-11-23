
package pl.edu.agh.eaiib.auctions.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetAuctionsForManager complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAuctionsForManager">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AMLogin" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "GetAuctionsForManager", propOrder = {
    "amLogin",
    "auctionListFilter"
})
public class GetAuctionsForManager {

    @XmlElement(name = "AMLogin", required = true)
    protected String amLogin;
    @XmlElement(name = "AuctionListFilter")
    protected AuctionListFilterType auctionListFilter;

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
