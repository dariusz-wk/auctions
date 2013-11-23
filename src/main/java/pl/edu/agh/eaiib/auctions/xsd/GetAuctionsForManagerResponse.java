
package pl.edu.agh.eaiib.auctions.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetAuctionsForManagerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAuctionsForManagerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AMLogin" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "GetAuctionsForManagerResponse", propOrder = {
    "amLogin",
    "auctionList"
})
public class GetAuctionsForManagerResponse {

    @XmlElement(name = "AMLogin", required = true)
    protected String amLogin;
    @XmlElement(name = "AuctionList", required = true)
    protected AuctionListType auctionList;

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
