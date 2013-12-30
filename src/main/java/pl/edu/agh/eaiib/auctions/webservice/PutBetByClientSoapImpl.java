package pl.edu.agh.eaiib.auctions.webservice;

import java.util.Calendar;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import pl.edu.agh.eaiib.auctions.core.webservice.SoapWebService;
import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.model.Bet;
import pl.edu.agh.eaiib.auctions.utils.Utils;
import pl.edu.agh.eaiib.auctions.wsdl.PutBetByClientSoap;
import pl.edu.agh.eaiib.auctions.xsd.AuctionType;
import pl.edu.agh.eaiib.auctions.xsd.BetListType;
import pl.edu.agh.eaiib.auctions.xsd.BetType;

@WebService(targetNamespace = "http://eaiib.agh.edu.pl/auctions/wsdl/", name = "PutBetByClientSoap")
@XmlSeeAlso({ pl.edu.agh.eaiib.auctions.xsd.ObjectFactory.class })
public class PutBetByClientSoapImpl extends SoapWebService implements PutBetByClientSoap {

    private static final Logger log = Logger.getLogger(PutBetByClientSoapImpl.class);

    @Override
    public void putBetByClient(Holder<String> clientLoginHolder, String auctionId, BetType bet, Holder<AuctionType> auction, Holder<String> errors) {
        log.trace("putBetByClient");

        String clientLogin = clientLoginHolder.value;

        clientLoginHolder.value = null;

        String e = null;
        if ( !hasClientPrivilages(clientLogin, e) ) {
            log.trace("Lack of privileges!");
            errors.value = e;
            return;
        }

        String errorMsg = null;
        if ( null != (errorMsg = validate(clientLogin, auctionId, bet)) ) {
            log.error("error: " + errorMsg);
            errors.value = errorMsg;
            return;
        }

        Bet betBean = new Bet();
        betBean.setBetPrice(Utils.parseDouble(bet.getBetPrice()));
        betBean.setBetTime(Calendar.getInstance().getTime());
        betBean.setCientId(clientLogin);

        Auction auctionBean = auctionService.addBet(Utils.parseLong(auctionId), betBean);
        if ( auctionBean.getError() != null ) {
            log.error("adding bet to auction faild");
            errors.value = "Cannot add bet to auction " + auctionId + ": " + auctionBean.getError();
            return;
        }
        AuctionType auctionOut = new AuctionType();
        auctionOut.setAuctionId(auctionBean.getId().toString());
        auctionOut.setAMLogin(auctionBean.getAmLogin());
        auctionOut.setAuctionCurrentPrice(Utils.formatCurrency(auctionBean.getAuctionCurrentPrice()));

        BetType bestBetOut = new BetType();
        Bet bestBet = auctionBean.getBetList().get(auctionBean.getBetList().size() - 1);
        bestBetOut.setBetPrice(Utils.formatCurrency(bestBet.getBetPrice()));
        bestBetOut.setClientLogin(bestBet.getCientId());
        bestBetOut.setBetTime(Utils.formatGeorgianCalendar(bestBet.getBetTime()));

        BetListType betList = new BetListType();
        betList.getBet().add(bestBetOut);

        auctionOut.setBetList(betList);
        auction.value = auctionOut;
    }

    private String validate(String clientLogin, String auctionId, BetType bet) {
        String errors = "";
        if ( Utils.isBlank(clientLogin) ) {
            errors += "ClientLogin cannot be null;\n";
        } else if ( !Utils.isLogin(clientLogin) ) {
            errors += "ClientLogin contains invalid characters. Alpha required;\n";
        }
        if ( Utils.isBlank(auctionId) ) {
            errors += "AuctionId cannot be null;\n";
        } else if ( !Utils.isNumeric(auctionId) ) {
            errors += "AuctionId contains invalid characters. Numeric required;\n";
        }
        if ( bet == null ) {
            errors += "Bet cannot be null;\n";
        } else {
            if ( Utils.isBlank(bet.getBetPrice()) ) {
                errors += "BetPrice cannot be null;\n";
            } else if ( !Utils.isCurrency(bet.getBetPrice()) ) {
                errors += "BetPrice invalid currency 00.00 required;\n";
            }
        }

        return Utils.isBlank(errors) ? null : errors;
    }

}
