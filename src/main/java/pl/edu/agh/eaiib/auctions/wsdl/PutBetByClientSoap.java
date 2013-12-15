package pl.edu.agh.eaiib.auctions.wsdl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.7
 * 2013-12-15T01:04:42.605+01:00
 * Generated source version: 2.7.7
 * 
 */
@WebService(targetNamespace = "http://eaiib.agh.edu.pl/auctions/wsdl/", name = "PutBetByClientSoap")
@XmlSeeAlso({pl.edu.agh.eaiib.auctions.xsd.ObjectFactory.class})
public interface PutBetByClientSoap {

    /**
     * Method for pushing bets by Client for aucion
     */
    @RequestWrapper(localName = "PutBetByClient", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/", className = "pl.edu.agh.eaiib.auctions.xsd.PutBetByClient")
    @WebMethod(operationName = "PutBetByClient", action = "http://eaiib.agh.edu.pl/auction/PutBetByClient")
    @ResponseWrapper(localName = "PutBetByClientResponse", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/", className = "pl.edu.agh.eaiib.auctions.xsd.PutBetByClientResponse")
    public void putBetByClient(
        @WebParam(mode = WebParam.Mode.INOUT, name = "ClientLogin", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/")
        javax.xml.ws.Holder<java.lang.String> clientLogin,
        @WebParam(name = "AuctionId", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/")
        java.lang.String auctionId,
        @WebParam(name = "Bet", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/")
        pl.edu.agh.eaiib.auctions.xsd.BetType bet,
        @WebParam(mode = WebParam.Mode.OUT, name = "Auction", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/")
        javax.xml.ws.Holder<pl.edu.agh.eaiib.auctions.xsd.AuctionType> auction,
        @WebParam(mode = WebParam.Mode.OUT, name = "Errors", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/")
        javax.xml.ws.Holder<java.lang.String> errors
    );
}
