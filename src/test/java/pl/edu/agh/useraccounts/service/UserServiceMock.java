package pl.edu.agh.useraccounts.service;

import java.util.List;

public class UserServiceMock implements UserService {

	@Override
	public int changePassword(String login, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int register(String login, String email, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int changeEmail(String login, String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remindPassword(String login) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int authorization(String login, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeUser(String login) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
