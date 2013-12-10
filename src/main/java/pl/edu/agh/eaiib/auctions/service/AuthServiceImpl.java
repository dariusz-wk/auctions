package pl.edu.agh.eaiib.auctions.service;

public class AuthServiceImpl implements AuthService {

	@Override
	public boolean hasManagementPrivileges(String login) {
		return (login.equals("AM"));
	}

	@Override
	public boolean hasClientPrivileges(String login) {
		return (login.equals("Client"));
	}

}
