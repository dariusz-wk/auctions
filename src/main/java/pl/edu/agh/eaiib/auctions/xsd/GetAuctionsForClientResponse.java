
package pl.edu.agh.eaiib.auctions.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetAuctionsForClientResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAuctionsForClientResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClientLogin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AuctionList" type="{http://eaiib.agh.edu.pl/auctions/xsd/}AuctionListType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAuctionsForClientResponse", propOrder = {
    "clientLogin",
    "auctionList"
})
public class GetAuctionsForClientResponse {

    @XmlElement(name = "ClientLogin", required = true)
    protected String clientLogin;
    @XmlElement(name = "AuctionList", required = true)
    protected AuctionListType auctionList;

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
     * Gets the value of the auctionList property.
     * 
     * @return
     *     possible object is
     *     {@link AuctionListType }
     *     
     */
    public AuctionListType getAuctionList() {
        return auctionList;
    }

    /**
     * Sets the value of the auctionList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuctionListType }
     *     
     */
    public void setAuctionList(AuctionListType value) {
        this.auctionList = value;
    }

}
