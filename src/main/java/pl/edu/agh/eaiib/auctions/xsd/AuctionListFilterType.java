
package pl.edu.agh.eaiib.auctions.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AuctionListFilterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuctionListFilterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuctionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuctionTitleFilter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Finished" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="My" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FilterDateFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="FilterDateTill" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuctionListFilterType", propOrder = {
    "auctionId",
    "auctionTitleFilter",
    "finished",
    "my",
    "filterDateFrom",
    "filterDateTill"
})
public class AuctionListFilterType {

    @XmlElement(name = "AuctionId")
    protected String auctionId;
    @XmlElement(name = "AuctionTitleFilter")
    protected String auctionTitleFilter;
    @XmlElement(name = "Finished")
    protected Boolean finished;
    @XmlElement(name = "My")
    protected Boolean my;
    @XmlElement(name = "FilterDateFrom")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar filterDateFrom;
    @XmlElement(name = "FilterDateTill")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar filterDateTill;

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
     * Gets the value of the auctionTitleFilter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuctionTitleFilter() {
        return auctionTitleFilter;
    }

    /**
     * Sets the value of the auctionTitleFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuctionTitleFilter(String value) {
        this.auctionTitleFilter = value;
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
     * Gets the value of the my property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMy() {
        return my;
    }

    /**
     * Sets the value of the my property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMy(Boolean value) {
        this.my = value;
    }

    /**
     * Gets the value of the filterDateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFilterDateFrom() {
        return filterDateFrom;
    }

    /**
     * Sets the value of the filterDateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFilterDateFrom(XMLGregorianCalendar value) {
        this.filterDateFrom = value;
    }

    /**
     * Gets the value of the filterDateTill property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFilterDateTill() {
        return filterDateTill;
    }

    /**
     * Sets the value of the filterDateTill property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFilterDateTill(XMLGregorianCalendar value) {
        this.filterDateTill = value;
    }

}
