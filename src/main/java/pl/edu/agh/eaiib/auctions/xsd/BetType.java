
package pl.edu.agh.eaiib.auctions.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for BetType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BetType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BetPrice" type="{http://eaiib.agh.edu.pl/auctions/xsd/}Price"/>
 *         &lt;element name="BetTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ClientLogin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BetType", propOrder = {
    "betPrice",
    "betTime",
    "clientLogin"
})
public class BetType {

    @XmlElement(name = "BetPrice", required = true)
    protected String betPrice;
    @XmlElement(name = "BetTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar betTime;
    @XmlElement(name = "ClientLogin", required = true)
    protected String clientLogin;

    /**
     * Gets the value of the betPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBetPrice() {
        return betPrice;
    }

    /**
     * Sets the value of the betPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBetPrice(String value) {
        this.betPrice = value;
    }

    /**
     * Gets the value of the betTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBetTime() {
        return betTime;
    }

    /**
     * Sets the value of the betTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBetTime(XMLGregorianCalendar value) {
        this.betTime = value;
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

}
