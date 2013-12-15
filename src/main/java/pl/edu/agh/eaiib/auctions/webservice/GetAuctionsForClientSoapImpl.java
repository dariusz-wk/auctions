package pl.edu.agh.eaiib.auctions.webservice;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;

import pl.edu.agh.eaiib.auctions.wsdl.GetAuctionsForClientSoap;
import pl.edu.agh.eaiib.auctions.xsd.AuctionListFilterType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionListType;

@WebService(targetNamespace = "http://eaiib.agh.edu.pl/auctions/wsdl/", name = "GetAuctionsForClientSoap")
@XmlSeeAlso({ pl.edu.agh.eaiib.auctions.xsd.ObjectFactory.class })
public class GetAuctionsForClientSoapImpl implements GetAuctionsForClientSoap {

	@Override
	public void getAuctionsForClient(Holder<String> clientLogin, AuctionListFilterType auctionListFilter, Holder<AuctionListType> auctionList, Holder<String> errors) {
		// TODO Auto-generated method stub

	}

}
