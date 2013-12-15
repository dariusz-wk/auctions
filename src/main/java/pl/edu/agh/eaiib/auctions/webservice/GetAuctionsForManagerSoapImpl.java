package pl.edu.agh.eaiib.auctions.webservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import pl.edu.agh.eaiib.auctions.core.webservice.SoapWebService;
import pl.edu.agh.eaiib.auctions.model.Auction;
import pl.edu.agh.eaiib.auctions.model.Bet;
import pl.edu.agh.eaiib.auctions.utils.Utils;
import pl.edu.agh.eaiib.auctions.wsdl.GetAuctionsForManagerSoap;
import pl.edu.agh.eaiib.auctions.xsd.AuctionListFilterType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionListType;
import pl.edu.agh.eaiib.auctions.xsd.AuctionType;
import pl.edu.agh.eaiib.auctions.xsd.BetType;

@WebService(targetNamespace = "http://eaiib.agh.edu.pl/auctions/wsdl/", name = "GetAuctionsForManagerSoap")
@XmlSeeAlso({pl.edu.agh.eaiib.auctions.xsd.ObjectFactory.class})
public class GetAuctionsForManagerSoapImpl extends SoapWebService implements GetAuctionsForManagerSoap {

	private static final Logger log = Logger.getLogger(GetAuctionsForManagerSoapImpl.class);
	

	@Override
	public void getAuctionsForManager(Holder<String> amLoginHolder, AuctionListFilterType auctionListFilter, Holder<AuctionListType> auctionList, Holder<String> errors) {
		log.trace("getAuctionsForManager " + amLoginHolder.value);
		// get references to incoming data
		String amLoginName = amLoginHolder.value;
		
		amLoginHolder.value = null;
		
		if (!hasMgmtPrivilages(amLoginName)) {
			log.trace("Lack of privileges!");
			errors.value = "Lack of provileges!";
			return;
		}
		
		List<Auction> auctionListItems = new ArrayList<Auction>();
		
		
		if(auctionListFilter.getAuctionId() != null){
			log.debug("Get specifix auction "+auctionListFilter.getAuctionId());
			Long auctionId = Utils.parseLong(auctionListFilter.getAuctionId());
			Auction a = auctionService.get(auctionId);
			if(a == null || !a.getAmLogin().equals(amLoginName)){
				errors.value = "No access"; 
				return;
			}			
			auctionListItems.add(a);
		} else {
			String title = "";
			boolean finished = false;
			String amLoginV = null;
			String clientLoginV = null;
			Date from = null;
			Date till = null;
			
			auctionListItems.addAll(auctionService.find(title, finished, amLoginV, clientLoginV, from, till));
			
		}
		
		auctionList.value= formatAuctionData(auctionListItems);
		
	}


	private AuctionListType formatAuctionData(List<Auction> auctionListItems) {
		AuctionListType auctionListHolder = new AuctionListType();
		for(Auction auctionBean:auctionListItems){
			AuctionType auction = new AuctionType();
			auction.setAMLogin(auctionBean.getAmLogin());
			auction.setAuctionCurrentPrice(Utils.formatCurrency(auctionBean.getAuctionCurrentPrice()==null?auctionBean.getAuctionStartPrice():auctionBean.getAuctionCurrentPrice()));
			auction.setAuctionDeliveryDesc(auctionBean.getAuctionDeliveryDesc());
			auction.setAuctionDescription(auctionBean.getAuctionDescription());
			auction.setAuctionEnd(Utils.formatGeorgianCalendar(auctionBean.getAuctionEnd()));
			auction.setAuctionTitle(auctionBean.getAuctionTitle());
			
			for(int i = auctionBean.getBetList().size()-1; i >=0 ; i--){
				Bet betBean = auctionBean.getBetList().get(i);
				BetType bet = new BetType();
				bet.setBetPrice(Utils.formatCurrency(betBean.getBetPrice()));
				bet.setClientLogin(betBean.getCientId());
				bet.setBetTime(Utils.formatGeorgianCalendar(betBean.getBetTime()));
				auction.getBetList().getBet().add(bet);
			}
			
			auctionListHolder.getAuction().add(auction);
		}		
		return auctionListHolder;
	}


}
