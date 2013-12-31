package pl.edu.agh.useraccounts.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pl.edu.agh.eaiib.auctions.service.AuthServiceImpl;

public class RoleServiceMock implements RoleService {

    @Override
    public List<String> getUserRole(String login) throws UserException_Exception {
        if ( login.equals("AMaccount") ) {
            return Arrays.asList(new String[] { AuthServiceImpl.AUCTION_MANAGER_ROLE });
        }
        if ( login.equals("Caccount") ) {
            return Arrays.asList(new String[] { AuthServiceImpl.AUCTION_CLIENT_ROLE });
        }
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
