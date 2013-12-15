package pl.edu.agh.eaiib.auctions.core.webservice;

import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.agh.eaiib.auctions.service.AuctionService;
import pl.edu.agh.eaiib.auctions.service.AuthService;

public class SoapWebService {

	@Autowired
	protected AuctionService auctionService;
	@Autowired
	protected AuthService authService;

	public SoapWebService() {
		super();
	}

	protected boolean hasMgmtPrivilages(String value) {
		return authService.hasManagementPrivileges(value);
	}
	
	protected boolean hasClientPrivilages(String value) {
		return authService.hasClientPrivileges(value);
	}


}