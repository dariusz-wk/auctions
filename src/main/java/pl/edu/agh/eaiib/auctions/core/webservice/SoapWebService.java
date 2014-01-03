package pl.edu.agh.eaiib.auctions.core.webservice;

import java.util.List;

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
    private
    WebServiceContext context;

    public SoapWebService() {
        super();
    }

    protected boolean hasMgmtPrivilages(String value, List<String> error) {
        return authService.hasManagementPrivileges(getContext(), value, error);
    }

    protected boolean hasClientPrivilages(String value, List<String> error) {
        return authService.hasClientPrivileges(getContext(), value, error);
    }

    public WebServiceContext getContext() {
        return context;
    }

    public void setContext(WebServiceContext context) {
        this.context = context;
    }

}