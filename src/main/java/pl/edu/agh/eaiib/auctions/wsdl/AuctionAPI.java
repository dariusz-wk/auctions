package pl.edu.agh.eaiib.auctions.wsdl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.7
 * 2013-12-15T01:04:42.717+01:00
 * Generated source version: 2.7.7
 * 
 */
@WebServiceClient(name = "AuctionAPI", 
                  wsdlLocation = "file:../webapp/WEB-INF/AuctionAPI.wsdl",
                  targetNamespace = "http://eaiib.agh.edu.pl/auctions/wsdl/") 
public class AuctionAPI extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://eaiib.agh.edu.pl/auctions/wsdl/", "AuctionAPI");
    public final static QName PutBetByClientPort = new QName("http://eaiib.agh.edu.pl/auctions/wsdl/", "PutBetByClientPort");
    public final static QName PutAuctionByManagerPort = new QName("http://eaiib.agh.edu.pl/auctions/wsdl/", "PutAuctionByManagerPort");
    public final static QName GetAuctionsForClientPort = new QName("http://eaiib.agh.edu.pl/auctions/wsdl/", "GetAuctionsForClientPort");
    public final static QName GetAuctionsForManagerPort = new QName("http://eaiib.agh.edu.pl/auctions/wsdl/", "GetAuctionsForManagerPort");
    public final static QName PutAuctionFinalizationFormByClientPort = new QName("http://eaiib.agh.edu.pl/auctions/wsdl/", "PutAuctionFinalizationFormByClientPort");
    static {
        URL url = null;
        try {
            url = new URL("file:../webapp/WEB-INF/AuctionAPI.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(AuctionAPI.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:../webapp/WEB-INF/AuctionAPI.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public AuctionAPI(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public AuctionAPI(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AuctionAPI() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns PutBetByClientSoap
     */
    @WebEndpoint(name = "PutBetByClientPort")
    public PutBetByClientSoap getPutBetByClientPort() {
        return super.getPort(PutBetByClientPort, PutBetByClientSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PutBetByClientSoap
     */
    @WebEndpoint(name = "PutBetByClientPort")
    public PutBetByClientSoap getPutBetByClientPort(WebServiceFeature... features) {
        return super.getPort(PutBetByClientPort, PutBetByClientSoap.class, features);
    }
    /**
     *
     * @return
     *     returns PutAuctionByManagerSoap
     */
    @WebEndpoint(name = "PutAuctionByManagerPort")
    public PutAuctionByManagerSoap getPutAuctionByManagerPort() {
        return super.getPort(PutAuctionByManagerPort, PutAuctionByManagerSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PutAuctionByManagerSoap
     */
    @WebEndpoint(name = "PutAuctionByManagerPort")
    public PutAuctionByManagerSoap getPutAuctionByManagerPort(WebServiceFeature... features) {
        return super.getPort(PutAuctionByManagerPort, PutAuctionByManagerSoap.class, features);
    }
    /**
     *
     * @return
     *     returns GetAuctionsForClientSoap
     */
    @WebEndpoint(name = "GetAuctionsForClientPort")
    public GetAuctionsForClientSoap getGetAuctionsForClientPort() {
        return super.getPort(GetAuctionsForClientPort, GetAuctionsForClientSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GetAuctionsForClientSoap
     */
    @WebEndpoint(name = "GetAuctionsForClientPort")
    public GetAuctionsForClientSoap getGetAuctionsForClientPort(WebServiceFeature... features) {
        return super.getPort(GetAuctionsForClientPort, GetAuctionsForClientSoap.class, features);
    }
    /**
     *
     * @return
     *     returns GetAuctionsForManagerSoap
     */
    @WebEndpoint(name = "GetAuctionsForManagerPort")
    public GetAuctionsForManagerSoap getGetAuctionsForManagerPort() {
        return super.getPort(GetAuctionsForManagerPort, GetAuctionsForManagerSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GetAuctionsForManagerSoap
     */
    @WebEndpoint(name = "GetAuctionsForManagerPort")
    public GetAuctionsForManagerSoap getGetAuctionsForManagerPort(WebServiceFeature... features) {
        return super.getPort(GetAuctionsForManagerPort, GetAuctionsForManagerSoap.class, features);
    }
    /**
     *
     * @return
     *     returns PutAuctionFinalizationFormByClientSoap
     */
    @WebEndpoint(name = "PutAuctionFinalizationFormByClientPort")
    public PutAuctionFinalizationFormByClientSoap getPutAuctionFinalizationFormByClientPort() {
        return super.getPort(PutAuctionFinalizationFormByClientPort, PutAuctionFinalizationFormByClientSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PutAuctionFinalizationFormByClientSoap
     */
    @WebEndpoint(name = "PutAuctionFinalizationFormByClientPort")
    public PutAuctionFinalizationFormByClientSoap getPutAuctionFinalizationFormByClientPort(WebServiceFeature... features) {
        return super.getPort(PutAuctionFinalizationFormByClientPort, PutAuctionFinalizationFormByClientSoap.class, features);
    }

}
