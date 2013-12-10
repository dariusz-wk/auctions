
package pl.edu.agh.useraccounts.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.agh.useraccounts.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetLogs_QNAME = new QName("http://service.useraccounts.agh.edu.pl/", "getLogs");
    private final static QName _GetUserParam_QNAME = new QName("http://service.useraccounts.agh.edu.pl/", "getUserParam");
    private final static QName _UserException_QNAME = new QName("http://service.useraccounts.agh.edu.pl/", "UserException");
    private final static QName _GetUserParamResponse_QNAME = new QName("http://service.useraccounts.agh.edu.pl/", "getUserParamResponse");
    private final static QName _GetUserParamsResponse_QNAME = new QName("http://service.useraccounts.agh.edu.pl/", "getUserParamsResponse");
    private final static QName _GetLogsResponse_QNAME = new QName("http://service.useraccounts.agh.edu.pl/", "getLogsResponse");
    private final static QName _SetUserParamResponse_QNAME = new QName("http://service.useraccounts.agh.edu.pl/", "setUserParamResponse");
    private final static QName _GetUserParams_QNAME = new QName("http://service.useraccounts.agh.edu.pl/", "getUserParams");
    private final static QName _SetUserParam_QNAME = new QName("http://service.useraccounts.agh.edu.pl/", "setUserParam");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.agh.useraccounts.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Parameters }
     * 
     */
    public Parameters createParameters() {
        return new Parameters();
    }

    /**
     * Create an instance of {@link Parameters.Map }
     * 
     */
    public Parameters.Map createParametersMap() {
        return new Parameters.Map();
    }

    /**
     * Create an instance of {@link GetUserParamResponse }
     * 
     */
    public GetUserParamResponse createGetUserParamResponse() {
        return new GetUserParamResponse();
    }

    /**
     * Create an instance of {@link GetUserParamsResponse }
     * 
     */
    public GetUserParamsResponse createGetUserParamsResponse() {
        return new GetUserParamsResponse();
    }

    /**
     * Create an instance of {@link UserException }
     * 
     */
    public UserException createUserException() {
        return new UserException();
    }

    /**
     * Create an instance of {@link GetUserParam }
     * 
     */
    public GetUserParam createGetUserParam() {
        return new GetUserParam();
    }

    /**
     * Create an instance of {@link GetLogs }
     * 
     */
    public GetLogs createGetLogs() {
        return new GetLogs();
    }

    /**
     * Create an instance of {@link SetUserParam }
     * 
     */
    public SetUserParam createSetUserParam() {
        return new SetUserParam();
    }

    /**
     * Create an instance of {@link GetUserParams }
     * 
     */
    public GetUserParams createGetUserParams() {
        return new GetUserParams();
    }

    /**
     * Create an instance of {@link SetUserParamResponse }
     * 
     */
    public SetUserParamResponse createSetUserParamResponse() {
        return new SetUserParamResponse();
    }

    /**
     * Create an instance of {@link GetLogsResponse }
     * 
     */
    public GetLogsResponse createGetLogsResponse() {
        return new GetLogsResponse();
    }

    /**
     * Create an instance of {@link Parameters.Map.Entry }
     * 
     */
    public Parameters.Map.Entry createParametersMapEntry() {
        return new Parameters.Map.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLogs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.useraccounts.agh.edu.pl/", name = "getLogs")
    public JAXBElement<GetLogs> createGetLogs(GetLogs value) {
        return new JAXBElement<GetLogs>(_GetLogs_QNAME, GetLogs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserParam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.useraccounts.agh.edu.pl/", name = "getUserParam")
    public JAXBElement<GetUserParam> createGetUserParam(GetUserParam value) {
        return new JAXBElement<GetUserParam>(_GetUserParam_QNAME, GetUserParam.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.useraccounts.agh.edu.pl/", name = "UserException")
    public JAXBElement<UserException> createUserException(UserException value) {
        return new JAXBElement<UserException>(_UserException_QNAME, UserException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserParamResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.useraccounts.agh.edu.pl/", name = "getUserParamResponse")
    public JAXBElement<GetUserParamResponse> createGetUserParamResponse(GetUserParamResponse value) {
        return new JAXBElement<GetUserParamResponse>(_GetUserParamResponse_QNAME, GetUserParamResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserParamsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.useraccounts.agh.edu.pl/", name = "getUserParamsResponse")
    public JAXBElement<GetUserParamsResponse> createGetUserParamsResponse(GetUserParamsResponse value) {
        return new JAXBElement<GetUserParamsResponse>(_GetUserParamsResponse_QNAME, GetUserParamsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLogsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.useraccounts.agh.edu.pl/", name = "getLogsResponse")
    public JAXBElement<GetLogsResponse> createGetLogsResponse(GetLogsResponse value) {
        return new JAXBElement<GetLogsResponse>(_GetLogsResponse_QNAME, GetLogsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetUserParamResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.useraccounts.agh.edu.pl/", name = "setUserParamResponse")
    public JAXBElement<SetUserParamResponse> createSetUserParamResponse(SetUserParamResponse value) {
        return new JAXBElement<SetUserParamResponse>(_SetUserParamResponse_QNAME, SetUserParamResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserParams }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.useraccounts.agh.edu.pl/", name = "getUserParams")
    public JAXBElement<GetUserParams> createGetUserParams(GetUserParams value) {
        return new JAXBElement<GetUserParams>(_GetUserParams_QNAME, GetUserParams.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetUserParam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.useraccounts.agh.edu.pl/", name = "setUserParam")
    public JAXBElement<SetUserParam> createSetUserParam(SetUserParam value) {
        return new JAXBElement<SetUserParam>(_SetUserParam_QNAME, SetUserParam.class, null, value);
    }

}
