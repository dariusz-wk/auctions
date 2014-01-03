package pl.edu.agh.eaiib.auctions.wsdl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.1
 * 2014-01-03T14:55:16.529+01:00
 * Generated source version: 2.7.1
 * 
 */
@WebService(targetNamespace = "http://eaiib.agh.edu.pl/auctions/wsdl/", name = "PutAuctionFinalizationFormByClientSoap")
@XmlSeeAlso({pl.edu.agh.eaiib.auctions.xsd.ObjectFactory.class})
public interface PutAuctionFinalizationFormByClientSoap {

    /**
     * Method for pushing into system required form with finalization data
     */
    @RequestWrapper(localName = "PutAuctionFinalizationFormByClient", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/", className = "pl.edu.agh.eaiib.auctions.xsd.PutAuctionFinalizationFormByClient")
    @WebMethod(operationName = "PutAuctionFinalizationFormByClient", action = "http://eaiib.agh.edu.pl/auction/PutAuctionFinalizationFormByClient")
    @ResponseWrapper(localName = "PutAuctionFinalizationFormByClientResponse", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/", className = "pl.edu.agh.eaiib.auctions.xsd.PutAuctionFinalizationFormByClientResponse")
    public void putAuctionFinalizationFormByClient(
        @WebParam(name = "AuctionId", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/")
        java.lang.String auctionId,
        @WebParam(mode = WebParam.Mode.INOUT, name = "ClientLogin", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/")
        javax.xml.ws.Holder<java.lang.String> clientLogin,
        @WebParam(name = "ClientContactData", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/")
        pl.edu.agh.eaiib.auctions.xsd.ClientContactDataType clientContactData,
        @WebParam(mode = WebParam.Mode.OUT, name = "AMLogin", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/")
        javax.xml.ws.Holder<java.lang.String> amLogin,
        @WebParam(mode = WebParam.Mode.OUT, name = "AuctionManagerContactData", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/")
        javax.xml.ws.Holder<pl.edu.agh.eaiib.auctions.xsd.AuctionManagerContactDataType> auctionManagerContactData,
        @WebParam(mode = WebParam.Mode.OUT, name = "Auction", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/")
        javax.xml.ws.Holder<pl.edu.agh.eaiib.auctions.xsd.AuctionType> auction,
        @WebParam(mode = WebParam.Mode.OUT, name = "Errors", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/")
        javax.xml.ws.Holder<java.lang.String> errors
    );
}
