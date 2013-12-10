package pl.edu.agh.useraccounts.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.7
 * 2013-12-08T00:45:36.964+01:00
 * Generated source version: 2.7.7
 * 
 */
@WebService(targetNamespace = "http://service.useraccounts.agh.edu.pl/", name = "UserService")
@XmlSeeAlso({ObjectFactory.class})
public interface UserService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "changePassword", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.ChangePassword")
    @WebMethod
    @ResponseWrapper(localName = "changePasswordResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.ChangePasswordResponse")
    public int changePassword(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "oldPassword", targetNamespace = "")
        java.lang.String oldPassword,
        @WebParam(name = "newPassword", targetNamespace = "")
        java.lang.String newPassword
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "register", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.Register")
    @WebMethod
    @ResponseWrapper(localName = "registerResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.RegisterResponse")
    public int register(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "email", targetNamespace = "")
        java.lang.String email,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "changeEmail", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.ChangeEmail")
    @WebMethod
    @ResponseWrapper(localName = "changeEmailResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.ChangeEmailResponse")
    public int changeEmail(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "email", targetNamespace = "")
        java.lang.String email
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "remindPassword", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.RemindPassword")
    @WebMethod
    @ResponseWrapper(localName = "remindPasswordResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.RemindPasswordResponse")
    public int remindPassword(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "authorization", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.Authorization")
    @WebMethod
    @ResponseWrapper(localName = "authorizationResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.AuthorizationResponse")
    public int authorization(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "removeUser", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.RemoveUser")
    @WebMethod
    @ResponseWrapper(localName = "removeUserResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.RemoveUserResponse")
    public int removeUser(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getUsers", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.GetUsers")
    @WebMethod
    @ResponseWrapper(localName = "getUsersResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.GetUsersResponse")
    public java.util.List<java.lang.String> getUsers();
}
