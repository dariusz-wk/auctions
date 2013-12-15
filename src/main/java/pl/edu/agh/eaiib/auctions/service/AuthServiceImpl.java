package pl.edu.agh.eaiib.auctions.service;

public class AuthServiceImpl implements AuthService {

	@Override
	public boolean hasManagementPrivileges(String login) {
		return true;
	}

	@Override
	public boolean hasClientPrivileges(String login) {
		return true;
	}

}
