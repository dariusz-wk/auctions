
package pl.edu.agh.eaiib.auctions.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.agh.eaiib.auctions.xsd package. 
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

    private final static QName _PutAuctionFinalizationFormByClientResponse_QNAME = new QName("http://eaiib.agh.edu.pl/auctions/xsd/", "PutAuctionFinalizationFormByClientResponse");
    private final static QName _GetAuctionsForClientResponse_QNAME = new QName("http://eaiib.agh.edu.pl/auctions/xsd/", "GetAuctionsForClientResponse");
    private final static QName _PutAuctionFinalizationFormByClient_QNAME = new QName("http://eaiib.agh.edu.pl/auctions/xsd/", "PutAuctionFinalizationFormByClient");
    private final static QName _GetAuctionsForManager_QNAME = new QName("http://eaiib.agh.edu.pl/auctions/xsd/", "GetAuctionsForManager");
    private final static QName _PutBetByClient_QNAME = new QName("http://eaiib.agh.edu.pl/auctions/xsd/", "PutBetByClient");
    private final static QName _GetAuctionsForManagerResponse_QNAME = new QName("http://eaiib.agh.edu.pl/auctions/xsd/", "GetAuctionsForManagerResponse");
    private final static QName _PutAuctionByManagerResponse_QNAME = new QName("http://eaiib.agh.edu.pl/auctions/xsd/", "PutAuctionByManagerResponse");
    private final static QName _Error_QNAME = new QName("http://eaiib.agh.edu.pl/auctions/xsd/", "Error");
    private final static QName _PutAuctionByManager_QNAME = new QName("http://eaiib.agh.edu.pl/auctions/xsd/", "PutAuctionByManager");
    private final static QName _PutBetByClientResponse_QNAME = new QName("http://eaiib.agh.edu.pl/auctions/xsd/", "PutBetByClientResponse");
    private final static QName _GetAuctionsForClient_QNAME = new QName("http://eaiib.agh.edu.pl/auctions/xsd/", "GetAuctionsForClient");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.agh.eaiib.auctions.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PutBetByClient }
     * 
     */
    public PutBetByClient createPutBetByClient() {
        return new PutBetByClient();
    }

    /**
     * Create an instance of {@link GetAuctionsForManagerResponse }
     * 
     */
    public GetAuctionsForManagerResponse createGetAuctionsForManagerResponse() {
        return new GetAuctionsForManagerResponse();
    }

    /**
     * Create an instance of {@link PutAuctionByManagerResponse }
     * 
     */
    public PutAuctionByManagerResponse createPutAuctionByManagerResponse() {
        return new PutAuctionByManagerResponse();
    }

    /**
     * Create an instance of {@link PutAuctionFinalizationFormByClientResponse }
     * 
     */
    public PutAuctionFinalizationFormByClientResponse createPutAuctionFinalizationFormByClientResponse() {
        return new PutAuctionFinalizationFormByClientResponse();
    }

    /**
     * Create an instance of {@link GetAuctionsForManager }
     * 
     */
    public GetAuctionsForManager createGetAuctionsForManager() {
        return new GetAuctionsForManager();
    }

    /**
     * Create an instance of {@link PutAuctionFinalizationFormByClient }
     * 
     */
    public PutAuctionFinalizationFormByClient createPutAuctionFinalizationFormByClient() {
        return new PutAuctionFinalizationFormByClient();
    }

    /**
     * Create an instance of {@link GetAuctionsForClientResponse }
     * 
     */
    public GetAuctionsForClientResponse createGetAuctionsForClientResponse() {
        return new GetAuctionsForClientResponse();
    }

    /**
     * Create an instance of {@link PutBetByClientResponse }
     * 
     */
    public PutBetByClientResponse createPutBetByClientResponse() {
        return new PutBetByClientResponse();
    }

    /**
     * Create an instance of {@link GetAuctionsForClient }
     * 
     */
    public GetAuctionsForClient createGetAuctionsForClient() {
        return new GetAuctionsForClient();
    }

    /**
     * Create an instance of {@link PutAuctionByManager }
     * 
     */
    public PutAuctionByManager createPutAuctionByManager() {
        return new PutAuctionByManager();
    }

    /**
     * Create an instance of {@link BetType }
     * 
     */
    public BetType createBetType() {
        return new BetType();
    }

    /**
     * Create an instance of {@link AuctionManagerContactDataType }
     * 
     */
    public AuctionManagerContactDataType createAuctionManagerContactDataType() {
        return new AuctionManagerContactDataType();
    }

    /**
     * Create an instance of {@link AuctionListType }
     * 
     */
    public AuctionListType createAuctionListType() {
        return new AuctionListType();
    }

    /**
     * Create an instance of {@link AuctionType }
     * 
     */
    public AuctionType createAuctionType() {
        return new AuctionType();
    }

    /**
     * Create an instance of {@link AuctionListFilterType }
     * 
     */
    public AuctionListFilterType createAuctionListFilterType() {
        return new AuctionListFilterType();
    }

    /**
     * Create an instance of {@link ClientContactDataType }
     * 
     */
    public ClientContactDataType createClientContactDataType() {
        return new ClientContactDataType();
    }

    /**
     * Create an instance of {@link BetListType }
     * 
     */
    public BetListType createBetListType() {
        return new BetListType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutAuctionFinalizationFormByClientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eaiib.agh.edu.pl/auctions/xsd/", name = "PutAuctionFinalizationFormByClientResponse")
    public JAXBElement<PutAuctionFinalizationFormByClientResponse> createPutAuctionFinalizationFormByClientResponse(PutAuctionFinalizationFormByClientResponse value) {
        return new JAXBElement<PutAuctionFinalizationFormByClientResponse>(_PutAuctionFinalizationFormByClientResponse_QNAME, PutAuctionFinalizationFormByClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuctionsForClientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eaiib.agh.edu.pl/auctions/xsd/", name = "GetAuctionsForClientResponse")
    public JAXBElement<GetAuctionsForClientResponse> createGetAuctionsForClientResponse(GetAuctionsForClientResponse value) {
        return new JAXBElement<GetAuctionsForClientResponse>(_GetAuctionsForClientResponse_QNAME, GetAuctionsForClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutAuctionFinalizationFormByClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eaiib.agh.edu.pl/auctions/xsd/", name = "PutAuctionFinalizationFormByClient")
    public JAXBElement<PutAuctionFinalizationFormByClient> createPutAuctionFinalizationFormByClient(PutAuctionFinalizationFormByClient value) {
        return new JAXBElement<PutAuctionFinalizationFormByClient>(_PutAuctionFinalizationFormByClient_QNAME, PutAuctionFinalizationFormByClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuctionsForManager }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eaiib.agh.edu.pl/auctions/xsd/", name = "GetAuctionsForManager")
    public JAXBElement<GetAuctionsForManager> createGetAuctionsForManager(GetAuctionsForManager value) {
        return new JAXBElement<GetAuctionsForManager>(_GetAuctionsForManager_QNAME, GetAuctionsForManager.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutBetByClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eaiib.agh.edu.pl/auctions/xsd/", name = "PutBetByClient")
    public JAXBElement<PutBetByClient> createPutBetByClient(PutBetByClient value) {
        return new JAXBElement<PutBetByClient>(_PutBetByClient_QNAME, PutBetByClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuctionsForManagerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eaiib.agh.edu.pl/auctions/xsd/", name = "GetAuctionsForManagerResponse")
    public JAXBElement<GetAuctionsForManagerResponse> createGetAuctionsForManagerResponse(GetAuctionsForManagerResponse value) {
        return new JAXBElement<GetAuctionsForManagerResponse>(_GetAuctionsForManagerResponse_QNAME, GetAuctionsForManagerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutAuctionByManagerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eaiib.agh.edu.pl/auctions/xsd/", name = "PutAuctionByManagerResponse")
    public JAXBElement<PutAuctionByManagerResponse> createPutAuctionByManagerResponse(PutAuctionByManagerResponse value) {
        return new JAXBElement<PutAuctionByManagerResponse>(_PutAuctionByManagerResponse_QNAME, PutAuctionByManagerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eaiib.agh.edu.pl/auctions/xsd/", name = "Error")
    public JAXBElement<String> createError(String value) {
        return new JAXBElement<String>(_Error_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutAuctionByManager }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eaiib.agh.edu.pl/auctions/xsd/", name = "PutAuctionByManager")
    public JAXBElement<PutAuctionByManager> createPutAuctionByManager(PutAuctionByManager value) {
        return new JAXBElement<PutAuctionByManager>(_PutAuctionByManager_QNAME, PutAuctionByManager.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutBetByClientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eaiib.agh.edu.pl/auctions/xsd/", name = "PutBetByClientResponse")
    public JAXBElement<PutBetByClientResponse> createPutBetByClientResponse(PutBetByClientResponse value) {
        return new JAXBElement<PutBetByClientResponse>(_PutBetByClientResponse_QNAME, PutBetByClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuctionsForClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eaiib.agh.edu.pl/auctions/xsd/", name = "GetAuctionsForClient")
    public JAXBElement<GetAuctionsForClient> createGetAuctionsForClient(GetAuctionsForClient value) {
        return new JAXBElement<GetAuctionsForClient>(_GetAuctionsForClient_QNAME, GetAuctionsForClient.class, null, value);
    }

}
