package pl.edu.agh.useraccounts.service;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.7
 * 2013-12-08T00:45:33.584+01:00
 * Generated source version: 2.7.7
 * 
 */
@WebServiceClient(name = "RoleServiceImplService", 
                  wsdlLocation = "RoleService.wsdl",
                  targetNamespace = "http://service.useraccounts.agh.edu.pl/") 
public class RoleServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://service.useraccounts.agh.edu.pl/", "RoleServiceImplService");
    public final static QName RoleServiceImplPort = new QName("http://service.useraccounts.agh.edu.pl/", "RoleServiceImplPort");
    static {
        URL url = RoleServiceImplService.class.getResource("RoleService.wsdl");
        if (url == null) {
            url = RoleServiceImplService.class.getClassLoader().getResource("RoleService.wsdl");
        } 
        if (url == null) {
            java.util.logging.Logger.getLogger(RoleServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "RoleService.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public RoleServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public RoleServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RoleServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns RoleService
     */
    @WebEndpoint(name = "RoleServiceImplPort")
    public RoleService getRoleServiceImplPort() {
        return super.getPort(RoleServiceImplPort, RoleService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RoleService
     */
    @WebEndpoint(name = "RoleServiceImplPort")
    public RoleService getRoleServiceImplPort(WebServiceFeature... features) {
        return super.getPort(RoleServiceImplPort, RoleService.class, features);
    }

}
