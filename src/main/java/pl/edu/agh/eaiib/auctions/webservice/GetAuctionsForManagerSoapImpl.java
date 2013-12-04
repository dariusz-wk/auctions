package pl.edu.agh.eaiib.auctions.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import pl.edu.agh.eaiib.auctions.wsdl.GetAuctionsForManagerSoap;
import pl.edu.agh.eaiib.auctions.xsd.AuctionListFilterType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionListType;

@WebService(targetNamespace = "http://eaiib.agh.edu.pl/auctions/wsdl/", name = "GetAuctionsForManagerSoap")
@XmlSeeAlso({pl.edu.agh.eaiib.auctions.xsd.ObjectFactory.class})
public class GetAuctionsForManagerSoapImpl implements GetAuctionsForManagerSoap {

	@Override
	@RequestWrapper(localName = "GetAuctionsForManager", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/", className = "pl.edu.agh.eaiib.auctions.xsd.GetAuctionsForManager")
	@WebMethod(operationName = "GetAuctionsForManager", action = "http://eaiib.agh.edu.pl/auction/GetAuctionsForManager")
	@ResponseWrapper(localName = "GetAuctionsForManagerResponse", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/", className = "pl.edu.agh.eaiib.auctions.xsd.GetAuctionsForManagerResponse")
	public void getAuctionsForManager(@WebParam(mode = Mode.INOUT, name = "AMLogin", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") Holder<String> amLogin,
			@WebParam(name = "AuctionListFilter", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") AuctionListFilterType auctionListFilter,
			@WebParam(mode = Mode.OUT, name = "AuctionList", targetNamespace = "http://eaiib.agh.edu.pl/auctions/xsd/") Holder<AuctionListType> auctionList) {
		// TODO Auto-generated method stub

	}

}
