package pl.edu.agh.eaiib.auctions.webservice;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import pl.edu.agh.eaiib.auctions.core.webservice.SoapWebService;
import pl.edu.agh.eaiib.auctions.wsdl.PutAuctionFinalizationFormByClientSoap;
import pl.edu.agh.eaiib.auctions.xsd.AuctionManagerContactDataType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionType;
import pl.edu.agh.eaiib.auctions.xsd.ClientContactDataType;

@WebService(targetNamespace = "http://eaiib.agh.edu.pl/auctions/wsdl/", name = "PutAuctionFinalizationFormByClientSoap")
@XmlSeeAlso({pl.edu.agh.eaiib.auctions.xsd.ObjectFactory.class})
public class PutAuctionFinalizationFormByClientSoapImpl extends SoapWebService implements PutAuctionFinalizationFormByClientSoap {

	private static final Logger log = Logger.getLogger(PutAuctionFinalizationFormByClientSoapImpl.class);
	
	@Override
	public void putAuctionFinalizationFormByClient(String auctionId, Holder<String> clientLogin, ClientContactDataType clientContactData, Holder<String> amLogin, Holder<AuctionManagerContactDataType> auctionManagerContactData,
			Holder<AuctionType> auction, Holder<String> errors) {
		// TODO Auto-generated method stub
		
	}

}
