package pl.edu.agh.eaiib.auctions.xsd;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * <p>
 * Java class for AuctionListType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuctionListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Auction" type="{http://eaiib.agh.edu.pl/auctions/xsd/}AuctionType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuctionListType", propOrder = { "auction" })
public class AuctionListType {

    @XmlElement(name = "Auction", required = true)
    protected List<AuctionType> auction;

    /**
     * Gets the value of the auction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present
     * inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the auction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getAuction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link AuctionType }
     * 
     * 
     */
    public List<AuctionType> getAuction() {
        if ( auction == null ) {
            auction = new ArrayList<AuctionType>();
        }
        return this.auction;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
