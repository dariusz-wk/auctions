package pl.edu.agh.eaiib.auctions.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import pl.edu.agh.eaiib.auctions.wsdl.GetAuctionsForClientSoap;
import pl.edu.agh.eaiib.auctions.xsd.AuctionListFilterType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionListType;

public class GetAuctionsForClientSoapImpl implements GetAuctionsForClientSoap {

	@Override
	@RequestWrapper(localName = "GetAuctionsForClient", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/", className = "pl.edu.agh.eaiib.auctions.xsd.GetAuctionsForClient")
	@WebMethod(operationName = "GetAuctionsForClient", action = "http://eaiib.agh.edu.pl/auction/GetAuctionsForClient")
	@ResponseWrapper(localName = "GetAuctionsForClientResponse", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/", className = "pl.edu.agh.eaiib.auctions.xsd.GetAuctionsForClientResponse")
	public void getAuctionsForClient(@WebParam(mode = Mode.INOUT, name = "ClientLogin", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") Holder<String> clientLogin,
			@WebParam(name = "AuctionListFilter", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") AuctionListFilterType auctionListFilter,
			@WebParam(mode = Mode.OUT, name = "AuctionList", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") Holder<AuctionListType> auctionList) {
		// TODO Auto-generated method stub

	}

}
