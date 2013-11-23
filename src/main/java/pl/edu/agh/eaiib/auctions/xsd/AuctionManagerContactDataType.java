
package pl.edu.agh.eaiib.auctions.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuctionManagerContactDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuctionManagerContactDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AMName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AMSurname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AMPhone" type="{http://eaiib.agh.edu.pl/auctions/xsd/}Phone"/>
 *         &lt;element name="AMEmail" type="{http://eaiib.agh.edu.pl/auctions/xsd/}Email"/>
 *         &lt;element name="AMAccountNb" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AMAccountBank" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuctionManagerContactDataType", propOrder = {
    "amName",
    "amSurname",
    "amPhone",
    "amEmail",
    "amAccountNb",
    "amAccountBank"
})
public class AuctionManagerContactDataType {

    @XmlElement(name = "AMName", required = true)
    protected String amName;
    @XmlElement(name = "AMSurname", required = true)
    protected String amSurname;
    @XmlElement(name = "AMPhone", required = true)
    protected String amPhone;
    @XmlElement(name = "AMEmail", required = true)
    protected String amEmail;
    @XmlElement(name = "AMAccountNb", required = true)
    protected String amAccountNb;
    @XmlElement(name = "AMAccountBank", required = true)
    protected String amAccountBank;

    /**
     * Gets the value of the amName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAMName() {
        return amName;
    }

    /**
     * Sets the value of the amName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAMName(String value) {
        this.amName = value;
    }

    /**
     * Gets the value of the amSurname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAMSurname() {
        return amSurname;
    }

    /**
     * Sets the value of the amSurname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAMSurname(String value) {
        this.amSurname = value;
    }

    /**
     * Gets the value of the amPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAMPhone() {
        return amPhone;
    }

    /**
     * Sets the value of the amPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAMPhone(String value) {
        this.amPhone = value;
    }

    /**
     * Gets the value of the amEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAMEmail() {
        return amEmail;
    }

    /**
     * Sets the value of the amEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAMEmail(String value) {
        this.amEmail = value;
    }

    /**
     * Gets the value of the amAccountNb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAMAccountNb() {
        return amAccountNb;
    }

    /**
     * Sets the value of the amAccountNb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAMAccountNb(String value) {
        this.amAccountNb = value;
    }

    /**
     * Gets the value of the amAccountBank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAMAccountBank() {
        return amAccountBank;
    }

    /**
     * Sets the value of the amAccountBank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAMAccountBank(String value) {
        this.amAccountBank = value;
    }

}
