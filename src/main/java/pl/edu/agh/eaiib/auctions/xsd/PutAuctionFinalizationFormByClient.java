
package pl.edu.agh.eaiib.auctions.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PutAuctionFinalizationFormByClient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PutAuctionFinalizationFormByClient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuctionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClientLogin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClientContactData" type="{http://eaiib.agh.edu.pl/auctions/xsd/}ClientContactDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PutAuctionFinalizationFormByClient", propOrder = {
    "auctionId",
    "clientLogin",
    "clientContactData"
})
public class PutAuctionFinalizationFormByClient {

    @XmlElement(name = "AuctionId", required = true)
    protected String auctionId;
    @XmlElement(name = "ClientLogin", required = true)
    protected String clientLogin;
    @XmlElement(name = "ClientContactData", required = true)
    protected ClientContactDataType clientContactData;

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
     * Gets the value of the clientContactData property.
     * 
     * @return
     *     possible object is
     *     {@link ClientContactDataType }
     *     
     */
    public ClientContactDataType getClientContactData() {
        return clientContactData;
    }

    /**
     * Sets the value of the clientContactData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientContactDataType }
     *     
     */
    public void setClientContactData(ClientContactDataType value) {
        this.clientContactData = value;
    }

}
