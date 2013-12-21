package pl.edu.agh.useraccounts.service;

import java.util.Collections;
import java.util.List;

public class RoleServiceMock implements RoleService {

	@Override
	public List<String> getUserRole(String login) throws UserException_Exception {
		// TODO Auto-generated method stub
		return Collections.EMPTY_LIST;
	}

	@Override
	public int addRole(String login, String role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeRole(String role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int revokeRole(String login, String role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createRole(String role) {
		// TODO Auto-generated method stub
		return 0;
	}

}
