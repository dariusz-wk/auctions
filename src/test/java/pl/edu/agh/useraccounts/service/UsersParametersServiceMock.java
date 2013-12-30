package pl.edu.agh.useraccounts.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

public class UsersParametersServiceMock implements UsersParametersService {

    @Override
    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getUserParam", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.GetUserParam")
    @WebMethod
    @ResponseWrapper(localName = "getUserParamResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.GetUserParamResponse")
    public String getUserParam(@WebParam(name = "login", targetNamespace = "")
    String login, @WebParam(name = "paramKey", targetNamespace = "")
    String paramKey) throws UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "setUserParam", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.SetUserParam")
    @WebMethod
    @ResponseWrapper(localName = "setUserParamResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.SetUserParamResponse")
    public int setUserParam(@WebParam(name = "login", targetNamespace = "")
    String login, @WebParam(name = "paramKey", targetNamespace = "")
    String paramKey, @WebParam(name = "paramValue", targetNamespace = "")
    String paramValue) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getUserParams", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.GetUserParams")
    @WebMethod
    @ResponseWrapper(localName = "getUserParamsResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.GetUserParamsResponse")
    public Parameters getUserParams(@WebParam(name = "login", targetNamespace = "")
    String login) throws UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getLogs", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.GetLogs")
    @WebMethod
    @ResponseWrapper(localName = "getLogsResponse", targetNamespace = "http://service.useraccounts.agh.edu.pl/", className = "pl.edu.agh.useraccounts.service.GetLogsResponse")
    public List<String> getLogs(@WebParam(name = "startTime", targetNamespace = "")
    XMLGregorianCalendar startTime, @WebParam(name = "endTime", targetNamespace = "")
    XMLGregorianCalendar endTime) throws UserException_Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
