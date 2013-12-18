package pl.edu.agh.eaiib.auctions.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthServiceImpl implements AuthService {

	@Override
	public boolean hasManagementPrivileges(WebServiceContext context, String login) {
		System.out.println(getLoginAndPasswd(context).toString());
		return true;
	}

	@Override
	public boolean hasClientPrivileges(WebServiceContext context, String login) {
		System.out.println(getLoginAndPasswd(context).toString());
		return true;
	}
	
	private LoginAndPasswd getLoginAndPasswd(WebServiceContext context){
        MessageContext mctx = context.getMessageContext();
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List<String> userList = (List<String>) http_headers.get(BindingProvider.USERNAME_PROPERTY.toLowerCase());
		List<String> passList = (List<String>) http_headers.get(BindingProvider.PASSWORD_PROPERTY.toLowerCase());
        if(userList == null || passList == null || userList.isEmpty() || passList.isEmpty()){
        	return new LoginAndPasswd("", "");
        } 
        return new LoginAndPasswd(userList.get(0), passList.get(0));
	}
	
	private static class LoginAndPasswd{
		String login;
		String passowrd;
		public LoginAndPasswd(String login, String passwd) {
			this.login=login;
			this.passowrd = passwd;
		}
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}

}
