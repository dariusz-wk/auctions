
package pl.edu.agh.eaiib.auctions.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BetListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BetListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bet" type="{http://eaiib.agh.edu.pl/auctions/xsd/}BetType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BetListType", propOrder = {
    "bet"
})
public class BetListType {

    @XmlElement(name = "Bet", required = true)
    protected List<BetType> bet;

    /**
     * Gets the value of the bet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BetType }
     * 
     * 
     */
    public List<BetType> getBet() {
        if (bet == null) {
            bet = new ArrayList<BetType>();
        }
        return this.bet;
    }

}
