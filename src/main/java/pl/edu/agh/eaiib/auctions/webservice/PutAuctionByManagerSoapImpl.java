package pl.edu.agh.eaiib.auctions.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import pl.edu.agh.eaiib.auctions.wsdl.PutAuctionByManagerSoap;
import pl.edu.agh.eaiib.auctions.xsd.AuctionManagerContactDataType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionType;

public class PutAuctionByManagerSoapImpl implements PutAuctionByManagerSoap{

	@Override
	@RequestWrapper(localName = "PutAuctionByManager", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/", className = "pl.edu.agh.eaiib.auctions.xsd.PutAuctionByManager")
	@WebMethod(operationName = "PutAuctionByManager", action = "http://eaiib.agh.edu.pl/auction/PutAuctionByManager")
	@ResponseWrapper(localName = "PutAuctionByManagerResponse", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/", className = "pl.edu.agh.eaiib.auctions.xsd.PutAuctionByManagerResponse")
	public void putAuctionByManager(@WebParam(mode = Mode.INOUT, name = "Auction", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") Holder<AuctionType> auction,
			@WebParam(mode = Mode.INOUT, name = "AMLogin", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") Holder<String> amLogin,
			@WebParam(name = "AuctionManagerContactData", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") AuctionManagerContactDataType auctionManagerContactData) {
		// TODO Auto-generated method stub
		
	}

}
