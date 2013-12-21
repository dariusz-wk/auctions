package pl.edu.agh.eaiib.auctions.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.agh.useraccounts.service.RoleService;
import pl.edu.agh.useraccounts.service.UserException_Exception;
import pl.edu.agh.useraccounts.service.UserService;

public class AuthServiceImpl implements AuthService {

	private static final String USERNAME_PROPERTY = "username";

	private static final String PASSWORD_PROPERTY = "password";

	private boolean demo;

	public static String AUCTION_MANAGER_ROLE = "AUCTION_MANAGER_ROLE";
	public static String AUCTION_CLIENT_ROLE = "AUCTION_CLIENT_ROLE";
	
	private RoleService roleWebServiceClient;

	private UserService userWebServiceClient;

	@Override
	public boolean hasManagementPrivileges(WebServiceContext context, String login) {
		LoginAndPasswd lp = getLoginAndPasswd(context);
		if (!demo) {
			if (false == login.equals(lp.login)) {
				return false;
			}
			int result = getUserWebServiceClient().authorization(lp.login, lp.passowrd);
			if (result == 0) {
				List<String> roles;
				try {
					roles = getRoleWebServiceClient().getUserRole(lp.login);
				} catch (UserException_Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
				if (!roles.contains(AUCTION_MANAGER_ROLE)) {
					return false;
				}
				return true;
			}
			return false;
		}
		System.out.println(lp.toString());
		return true;
	}

	@Override
	public boolean hasClientPrivileges(WebServiceContext context, String login) {
		LoginAndPasswd lp = getLoginAndPasswd(context);
		if (!demo) {
			if (false == login.equals(lp.login)) {
				return false;
			}
			int result = getUserWebServiceClient().authorization(lp.login, lp.passowrd);
			if (result == 0) {
				List<String> roles;
				try {
					roles = getRoleWebServiceClient().getUserRole(lp.login);
				} catch (UserException_Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
				if (!roles.contains(AUCTION_CLIENT_ROLE)) {
					return false;
				}
				return true;
			}
			return false;
		}
		return true;
	}

	private LoginAndPasswd getLoginAndPasswd(WebServiceContext context) {
		MessageContext mctx = context.getMessageContext();
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List<String> userList = (List<String>) http_headers.get(USERNAME_PROPERTY);
		List<String> passList = (List<String>) http_headers.get(PASSWORD_PROPERTY);
		if (userList == null || passList == null || userList.isEmpty() || passList.isEmpty()) {
			return new LoginAndPasswd("", "");
		}
		return new LoginAndPasswd(userList.get(0), passList.get(0));
	}

	public void setDemo(boolean demo) {
		this.demo = demo;
	}

	public RoleService getRoleWebServiceClient() {
		return roleWebServiceClient;
	}

	public void setRoleWebServiceClient(RoleService roleWebServiceClient) {
		this.roleWebServiceClient = roleWebServiceClient;
	}

	public UserService getUserWebServiceClient() {
		return userWebServiceClient;
	}

	public void setUserWebServiceClient(UserService userWebServiceClient) {
		this.userWebServiceClient = userWebServiceClient;
	}

	private static class LoginAndPasswd {
		String login;
		String passowrd;

		public LoginAndPasswd(String login, String passwd) {
			this.login = login;
			this.passowrd = passwd;
		}

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}

}
