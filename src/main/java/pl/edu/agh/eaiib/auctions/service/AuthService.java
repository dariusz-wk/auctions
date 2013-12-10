package pl.edu.agh.eaiib.auctions.service;

public interface AuthService {
	public boolean hasManagementPrivileges(String login);

	public boolean hasClientPrivileges(String login);
}
