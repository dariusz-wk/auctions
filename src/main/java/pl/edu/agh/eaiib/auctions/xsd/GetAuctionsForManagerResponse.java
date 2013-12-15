
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
 *         &lt;element name="AMLogin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuctionList" type="{http://eaiib.agh.edu.pl/auctions/xsd/}AuctionListType" minOccurs="0"/>
 *         &lt;element name="Errors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "auctionList",
    "errors"
})
public class GetAuctionsForManagerResponse {

    @XmlElement(name = "AMLogin")
    protected String amLogin;
    @XmlElement(name = "AuctionList")
    protected AuctionListType auctionList;
    @XmlElement(name = "Errors")
    protected String errors;

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

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrors(String value) {
        this.errors = value;
    }

}
