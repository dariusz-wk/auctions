
package pl.edu.agh.eaiib.auctions.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClientContactDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClientContactDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClientName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClientSurname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClientAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClientPhone" type="{http://eaiib.agh.edu.pl/auctions/xsd/}Phone"/>
 *         &lt;element name="ClientEmail" type="{http://eaiib.agh.edu.pl/auctions/xsd/}Email"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClientContactDataType", propOrder = {
    "clientName",
    "clientSurname",
    "clientAddress",
    "clientPhone",
    "clientEmail"
})
public class ClientContactDataType {

    @XmlElement(name = "ClientName", required = true)
    protected String clientName;
    @XmlElement(name = "ClientSurname", required = true)
    protected String clientSurname;
    @XmlElement(name = "ClientAddress", required = true)
    protected String clientAddress;
    @XmlElement(name = "ClientPhone", required = true)
    protected String clientPhone;
    @XmlElement(name = "ClientEmail", required = true)
    protected String clientEmail;

    /**
     * Gets the value of the clientName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Sets the value of the clientName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientName(String value) {
        this.clientName = value;
    }

    /**
     * Gets the value of the clientSurname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientSurname() {
        return clientSurname;
    }

    /**
     * Sets the value of the clientSurname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientSurname(String value) {
        this.clientSurname = value;
    }

    /**
     * Gets the value of the clientAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientAddress() {
        return clientAddress;
    }

    /**
     * Sets the value of the clientAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientAddress(String value) {
        this.clientAddress = value;
    }

    /**
     * Gets the value of the clientPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientPhone() {
        return clientPhone;
    }

    /**
     * Sets the value of the clientPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientPhone(String value) {
        this.clientPhone = value;
    }

    /**
     * Gets the value of the clientEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientEmail() {
        return clientEmail;
    }

    /**
     * Sets the value of the clientEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientEmail(String value) {
        this.clientEmail = value;
    }

}
