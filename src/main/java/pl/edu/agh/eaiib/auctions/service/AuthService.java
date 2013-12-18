package pl.edu.agh.eaiib.auctions.service;

import javax.xml.ws.WebServiceContext;

public interface AuthService {
	public boolean hasManagementPrivileges(WebServiceContext context, String login);

	public boolean hasClientPrivileges(WebServiceContext context, String login);
}
