package pl.edu.agh.eaiib.auctions.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import pl.edu.agh.eaiib.auctions.core.webservice.SoapWebService;
import pl.edu.agh.eaiib.auctions.model.AMContact;
import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.model.Bet;
import pl.edu.agh.eaiib.auctions.model.BuyerContact;
import pl.edu.agh.eaiib.auctions.utils.Utils;
import pl.edu.agh.eaiib.auctions.wsdl.PutAuctionFinalizationFormByClientSoap;
import pl.edu.agh.eaiib.auctions.xsd.AuctionManagerContactDataType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionType;
import pl.edu.agh.eaiib.auctions.xsd.ClientContactDataType;

@WebService(targetNamespace = "http://eaiib.agh.edu.pl/auctions/wsdl/", name = "PutAuctionFinalizationFormByClientSoap")
@XmlSeeAlso({ pl.edu.agh.eaiib.auctions.xsd.ObjectFactory.class })
public class PutAuctionFinalizationFormByClientSoapImpl extends SoapWebService implements PutAuctionFinalizationFormByClientSoap {

    private static final Logger log = Logger.getLogger(PutAuctionFinalizationFormByClientSoapImpl.class);

    @Override
    public void putAuctionFinalizationFormByClient(String auctionId, Holder<String> clientLogin, ClientContactDataType clientContactData,
            Holder<String> amLogin, Holder<AuctionManagerContactDataType> auctionManagerContactData, Holder<AuctionType> auction, Holder<String> errors) {
        log.trace("putAuctionFinalizationFormByClient " + clientLogin.value);
        // get references to incoming data
        String clientLoginName = clientLogin.value;
        Long auctionI = Utils.parseLong(auctionId);

        // clear holders for output
        clientLogin.value = null;

        List<String> e = new ArrayList<String>();
        if ( !hasClientPrivilages(clientLoginName, e) ) {
            log.trace("Lack of privileges!");
            errors.value = e.toString();
            return;
        }

        String errorMsg = null;
        if ( null != (errorMsg = validate(clientContactData)) ) {
            log.error("error: " + errorMsg);
            errors.value = "errorMsg";
            return;
        }

        Auction auctionBean = auctionService.get(auctionI);

        Bet bestBet = auctionBean.getBetList().get(auctionBean.getBetList().size() - 1);
        if ( auction == null || auctionBean.getFinished() == false || auctionBean.getFinalized() || !bestBet.getCientId().equals(clientLoginName) ) {
            log.trace("Lack of privileges!");
            errors.value = "Lack of provileges!";
            return;
        }

        BuyerContact contact = new BuyerContact();
        contact.setAddress(clientContactData.getClientAddress());
        contact.setAuction(auctionBean);
        contact.setEmail(clientContactData.getClientEmail());
        contact.setLogin(clientLoginName);
        contact.setName(clientContactData.getClientName());
        contact.setPhone(clientContactData.getClientPhone());
        contact.setSurname(clientContactData.getClientSurname());
        auctionBean.setFinalized(true);

        auctionService.update(auctionBean);

        AMContact amContact = auctionBean.getAuctionManagerContact();
        AuctionManagerContactDataType auctionManagerContact = new AuctionManagerContactDataType();
        auctionManagerContact.setAMAccountBank(amContact.getBank());
        auctionManagerContact.setAMAccountNb(amContact.getBankAccountNb());
        auctionManagerContact.setAMEmail(amContact.getEmail());
        auctionManagerContact.setAMName(amContact.getName());
        auctionManagerContact.setAMPhone(amContact.getPhone());
        auctionManagerContact.setAMSurname(amContact.getSurname());
        auctionManagerContactData.value = auctionManagerContact;

        clientLogin.value = clientLoginName;
        amLogin.value = auctionBean.getAmLogin();
        AuctionType auctionOut = new AuctionType();
        auctionOut.setAuctionCurrentPrice(Utils.formatCurrency(auctionBean.getAuctionCurrentPrice()));
        auctionOut.setAuctionTitle(auctionBean.getAuctionTitle());
        auctionOut.setFinalized(auctionBean.getFinalized());
    }

    private String validate(ClientContactDataType clientContactData) {
        String error = "";
        if ( clientContactData == null ) {
            error += "ClientContactData cannot be null";
        } else {
            if ( Utils.isBlank(clientContactData.getClientAddress()) ) {
                error += "ClientAddres cannot be null and over 255 long";
            }
            if ( Utils.isEmail(clientContactData.getClientEmail()) ) {
                error += "ClientEmail invalid email format";
            }
            if ( Utils.isBlank(clientContactData.getClientName()) ) {
                error += "Client Name cannot be null or longer than 255";
            }
            if ( Utils.isBlank(clientContactData.getClientSurname()) ) {
                error += "ClientSurname cannot be null or longer than 255";
            }
            if ( Utils.isPhone(clientContactData.getClientPhone()) ) {
                error += "ClientPhone invalid format";
            }
        }
        return StringUtils.isBlank(error) ? null : error;
    }

}
