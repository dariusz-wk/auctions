package pl.edu.agh.eaiib.auctions.service;

import java.util.List;
import java.util.Map;

import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;

import pl.edu.agh.useraccounts.service.RoleService;
import pl.edu.agh.useraccounts.service.UserException_Exception;
import pl.edu.agh.useraccounts.service.UserService;
import pl.edu.agh.useraccounts.service.UsersParametersService;

public class AuthServiceImpl implements AuthService {

    private static Logger log = Logger.getLogger(AuthServiceImpl.class);

    public static final String USERNAME_PROPERTY = "username";

    public static final String PASSWORD_PROPERTY = "password";

    private boolean demo;

    public static String AUCTION_MANAGER_ROLE = "AUCTION_MANAGER_ROLE";

    public static String AUCTION_CLIENT_ROLE = "AUCTION_CLIENT_ROLE";

    public static String EMAIL = "email";

    private RoleService roleWebServiceClient;

    private UserService userWebServiceClient;

    private UsersParametersService usersParametersService;

    @Override
    public boolean hasManagementPrivileges(WebServiceContext context, String login, List<String> error) {
        return authorise(context, login, AUCTION_MANAGER_ROLE, error);
    }

    @Override
    public boolean hasClientPrivileges(WebServiceContext context, String login, List<String> error) {
        return authorise(context, login, AUCTION_CLIENT_ROLE, error);
    }

    private boolean authorise(WebServiceContext context, String login, String roleName, List<String> error) {
        LoginAndPasswd lp = getLoginAndPasswd(context);
        if ( !demo ) {
            if ( false == login.equals(lp.login) ) {
                error.add("Login missmatch in request and header");
                log.debug(error);
                return false;
            }
            int result = getUserWebServiceClient().authorization(lp.login, lp.passowrd);
            if ( result == 0 ) {
                List<String> roles;
                try {
                    roles = getRoleWebServiceClient().getUserRole(lp.login);
                } catch (UserException_Exception e) {
                    log.warn(e.getMessage(), e);
                    error.add(e.getMessage());
                    return false;
                }
                if ( !roles.contains(roleName) ) {
                    error.add("Missing role " + roleName + " for user");
                    log.debug(error);
                    return false;
                }
                return true;
            }
            error.add("Authorisation Service error: return code " + result);
            log.debug(error);
            return false;
        }
        log.debug("Auth successfull " + login + " " + roleName);
        return true;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private LoginAndPasswd getLoginAndPasswd(WebServiceContext context) {
        MessageContext mctx = context.getMessageContext();
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List<String> userList = (List<String>) http_headers.get(USERNAME_PROPERTY);
        List<String> passList = (List<String>) http_headers.get(PASSWORD_PROPERTY);
        LoginAndPasswd lp;
        if ( userList == null || passList == null || userList.isEmpty() || passList.isEmpty() ) {
            lp = new LoginAndPasswd("", "");
        } else {
            lp = new LoginAndPasswd(userList.get(0), passList.get(0));
        }
        log.debug(lp);
        return lp;
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

    @Override
    public String getEmail(String login) {
        try {
            return usersParametersService.getUserParam(login, EMAIL);
        } catch (UserException_Exception e) {
            log.warn(e.getMessage(), e);
            return null;
        }
    }

    public UsersParametersService getUsersParametersService() {
        return usersParametersService;
    }

    public void setUsersParametersService(UsersParametersService usersParametersService) {
        this.usersParametersService = usersParametersService;
    }

}
