
package pl.edu.agh.eaiib.auctions.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AuctionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuctionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuctionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuctionTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuctionImgUrl" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AuctionStart" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="AuctionEnd" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="AuctionStartPrice" type="{http://eaiib.agh.edu.pl/auctions/xsd/}Price" minOccurs="0"/>
 *         &lt;element name="AuctionCurrentPrice" type="{http://eaiib.agh.edu.pl/auctions/xsd/}Price" minOccurs="0"/>
 *         &lt;element name="AuctionDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuctionDeliveryDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Finished" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Won" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Finalized" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AMLogin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BetList" type="{http://eaiib.agh.edu.pl/auctions/xsd/}BetListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuctionType", propOrder = {
    "auctionId",
    "auctionTitle",
    "auctionImgUrl",
    "auctionStart",
    "auctionEnd",
    "auctionStartPrice",
    "auctionCurrentPrice",
    "auctionDescription",
    "auctionDeliveryDesc",
    "finished",
    "won",
    "finalized",
    "amLogin",
    "betList"
})
public class AuctionType {

    @XmlElement(name = "AuctionId")
    protected String auctionId;
    @XmlElement(name = "AuctionTitle")
    protected String auctionTitle;
    @XmlElement(name = "AuctionImgUrl")
    protected List<String> auctionImgUrl;
    @XmlElement(name = "AuctionStart")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar auctionStart;
    @XmlElement(name = "AuctionEnd")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar auctionEnd;
    @XmlElement(name = "AuctionStartPrice")
    protected String auctionStartPrice;
    @XmlElement(name = "AuctionCurrentPrice")
    protected String auctionCurrentPrice;
    @XmlElement(name = "AuctionDescription")
    protected String auctionDescription;
    @XmlElement(name = "AuctionDeliveryDesc")
    protected String auctionDeliveryDesc;
    @XmlElement(name = "Finished")
    protected Boolean finished;
    @XmlElement(name = "Won")
    protected Boolean won;
    @XmlElement(name = "Finalized")
    protected Boolean finalized;
    @XmlElement(name = "AMLogin")
    protected String amLogin;
    @XmlElement(name = "BetList")
    protected BetListType betList;

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
     * Gets the value of the auctionTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuctionTitle() {
        return auctionTitle;
    }

    /**
     * Sets the value of the auctionTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuctionTitle(String value) {
        this.auctionTitle = value;
    }

    /**
     * Gets the value of the auctionImgUrl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the auctionImgUrl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuctionImgUrl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAuctionImgUrl() {
        if (auctionImgUrl == null) {
            auctionImgUrl = new ArrayList<String>();
        }
        return this.auctionImgUrl;
    }

    /**
     * Gets the value of the auctionStart property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAuctionStart() {
        return auctionStart;
    }

    /**
     * Sets the value of the auctionStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAuctionStart(XMLGregorianCalendar value) {
        this.auctionStart = value;
    }

    /**
     * Gets the value of the auctionEnd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAuctionEnd() {
        return auctionEnd;
    }

    /**
     * Sets the value of the auctionEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAuctionEnd(XMLGregorianCalendar value) {
        this.auctionEnd = value;
    }

    /**
     * Gets the value of the auctionStartPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuctionStartPrice() {
        return auctionStartPrice;
    }

    /**
     * Sets the value of the auctionStartPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuctionStartPrice(String value) {
        this.auctionStartPrice = value;
    }

    /**
     * Gets the value of the auctionCurrentPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuctionCurrentPrice() {
        return auctionCurrentPrice;
    }

    /**
     * Sets the value of the auctionCurrentPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuctionCurrentPrice(String value) {
        this.auctionCurrentPrice = value;
    }

    /**
     * Gets the value of the auctionDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuctionDescription() {
        return auctionDescription;
    }

    /**
     * Sets the value of the auctionDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuctionDescription(String value) {
        this.auctionDescription = value;
    }

    /**
     * Gets the value of the auctionDeliveryDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuctionDeliveryDesc() {
        return auctionDeliveryDesc;
    }

    /**
     * Sets the value of the auctionDeliveryDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuctionDeliveryDesc(String value) {
        this.auctionDeliveryDesc = value;
    }

    /**
     * Gets the value of the finished property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFinished() {
        return finished;
    }

    /**
     * Sets the value of the finished property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFinished(Boolean value) {
        this.finished = value;
    }

    /**
     * Gets the value of the won property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWon() {
        return won;
    }

    /**
     * Sets the value of the won property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWon(Boolean value) {
        this.won = value;
    }

    /**
     * Gets the value of the finalized property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFinalized() {
        return finalized;
    }

    /**
     * Sets the value of the finalized property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFinalized(Boolean value) {
        this.finalized = value;
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

    /**
     * Gets the value of the betList property.
     * 
     * @return
     *     possible object is
     *     {@link BetListType }
     *     
     */
    public BetListType getBetList() {
        return betList;
    }

    /**
     * Sets the value of the betList property.
     * 
     * @param value
     *     allowed object is
     *     {@link BetListType }
     *     
     */
    public void setBetList(BetListType value) {
        this.betList = value;
    }

}
