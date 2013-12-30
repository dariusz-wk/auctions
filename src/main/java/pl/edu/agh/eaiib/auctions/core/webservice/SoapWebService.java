package pl.edu.agh.eaiib.auctions.core.webservice;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.agh.eaiib.auctions.service.AuctionService;
import pl.edu.agh.eaiib.auctions.service.AuthService;

public class SoapWebService {

    @Autowired
    protected AuctionService auctionService;

    @Autowired
    protected AuthService authService;

    @Resource
    WebServiceContext context;

    public SoapWebService() {
        super();
    }

    protected boolean hasMgmtPrivilages(String value, String error) {
        return authService.hasManagementPrivileges(context, value, error);
    }

    protected boolean hasClientPrivilages(String value, String error) {
        return authService.hasClientPrivileges(context, value, error);
    }

}