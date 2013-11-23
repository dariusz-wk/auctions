package pl.edu.agh.eaiib.auctions.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import pl.edu.agh.eaiib.auctions.wsdl.PutBetByClientSoap;
import pl.edu.agh.eaiib.auctions.xsd.AuctionType;
import pl.edu.agh.eaiib.auctions.xsd.BetType;

public class PutBetByClientSoapImpl implements PutBetByClientSoap {

	@Override
	@RequestWrapper(localName = "PutBetByClient", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/", className = "pl.edu.agh.eaiib.auctions.xsd.PutBetByClient")
	@WebMethod(operationName = "PutBetByClient", action = "http://eaiib.agh.edu.pl/auction/PutBetByClient")
	@ResponseWrapper(localName = "PutBetByClientResponse", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/", className = "pl.edu.agh.eaiib.auctions.xsd.PutBetByClientResponse")
	public void putBetByClient(@WebParam(mode = Mode.INOUT, name = "ClientLogin", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") Holder<String> clientLogin,
			@WebParam(name = "AuctionId", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") String auctionId, @WebParam(name = "Bet", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") BetType bet,
			@WebParam(mode = Mode.OUT, name = "Auction", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") Holder<AuctionType> auction) {
		// TODO Auto-generated method stub

	}

}
