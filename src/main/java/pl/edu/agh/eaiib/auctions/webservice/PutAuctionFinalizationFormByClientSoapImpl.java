package pl.edu.agh.eaiib.auctions.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import pl.edu.agh.eaiib.auctions.wsdl.PutAuctionFinalizationFormByClientSoap;
import pl.edu.agh.eaiib.auctions.xsd.AuctionManagerContactDataType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionType;
import pl.edu.agh.eaiib.auctions.xsd.ClientContactDataType;

public class PutAuctionFinalizationFormByClientSoapImpl implements PutAuctionFinalizationFormByClientSoap {

	@Override
	@RequestWrapper(localName = "PutAuctionFinalizationFormByClient", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/", className = "pl.edu.agh.eaiib.auctions.xsd.PutAuctionFinalizationFormByClient")
	@WebMethod(operationName = "PutAuctionFinalizationFormByClient", action = "http://eaiib.agh.edu.pl/auction/PutAuctionFinalizationFormByClient")
	@ResponseWrapper(localName = "PutAuctionFinalizationFormByClientResponse", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/", className = "pl.edu.agh.eaiib.auctions.xsd.PutAuctionFinalizationFormByClientResponse")
	public void putAuctionFinalizationFormByClient(@WebParam(name = "AuctionId", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") String auctionId,
			@WebParam(mode = Mode.INOUT, name = "ClientLogin", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") Holder<String> clientLogin,
			@WebParam(name = "ClientContactData", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") ClientContactDataType clientContactData,
			@WebParam(mode = Mode.OUT, name = "AMLogin", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") Holder<String> amLogin,
			@WebParam(mode = Mode.OUT, name = "AuctionManagerContactData", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") Holder<AuctionManagerContactDataType> auctionManagerContactData,
			@WebParam(mode = Mode.OUT, name = "Auction", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") Holder<AuctionType> auction) {
		// TODO Auto-generated method stub

	}

}
