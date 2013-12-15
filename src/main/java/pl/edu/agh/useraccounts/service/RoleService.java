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
 * 2013-12-08T00:45:33.552+01:00
 * Generated source version: 2.7.7
 * 
 */
@WebService(targetNamespace = "http://service.useraccounts.agh.edu.pl/", name = "RoleService")
@XmlSeeAlso({ObjectFactory.class})
public interface RoleService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getUserRole", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.GetUserRole")
    @WebMethod
    @ResponseWrapper(localName = "getUserRoleResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.GetUserRoleResponse")
    public java.util.List<java.lang.String> getUserRole(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login
    ) throws UserException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "addRole", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.AddRole")
    @WebMethod
    @ResponseWrapper(localName = "addRoleResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.AddRoleResponse")
    public int addRole(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "role", targetNamespace = "")
        java.lang.String role
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getAllRoles", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.GetAllRoles")
    @WebMethod
    @ResponseWrapper(localName = "getAllRolesResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.GetAllRolesResponse")
    public java.util.List<java.lang.String> getAllRoles();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "removeRole", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.RemoveRole")
    @WebMethod
    @ResponseWrapper(localName = "removeRoleResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.RemoveRoleResponse")
    public int removeRole(
        @WebParam(name = "role", targetNamespace = "")
        java.lang.String role
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "revokeRole", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.RevokeRole")
    @WebMethod
    @ResponseWrapper(localName = "revokeRoleResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.RevokeRoleResponse")
    public int revokeRole(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "role", targetNamespace = "")
        java.lang.String role
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createRole", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.CreateRole")
    @WebMethod
    @ResponseWrapper(localName = "createRoleResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.CreateRoleResponse")
    public int createRole(
        @WebParam(name = "role", targetNamespace = "")
        java.lang.String role
    );
}