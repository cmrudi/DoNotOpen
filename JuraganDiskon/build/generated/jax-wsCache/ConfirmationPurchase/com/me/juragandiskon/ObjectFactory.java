
package com.me.juragandiskon;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.me.juragandiskon package. 
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

    private final static QName _GetPurchaseInfo_QNAME = new QName("http://juragandiskon.me.com/", "getPurchaseInfo");
    private final static QName _GetPurchaseInfoResponse_QNAME = new QName("http://juragandiskon.me.com/", "getPurchaseInfoResponse");
    private final static QName _GetTotalPrice_QNAME = new QName("http://juragandiskon.me.com/", "getTotalPrice");
    private final static QName _GetTotalPriceResponse_QNAME = new QName("http://juragandiskon.me.com/", "getTotalPriceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.me.juragandiskon
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPurchaseInfo }
     * 
     */
    public GetPurchaseInfo createGetPurchaseInfo() {
        return new GetPurchaseInfo();
    }

    /**
     * Create an instance of {@link GetPurchaseInfoResponse }
     * 
     */
    public GetPurchaseInfoResponse createGetPurchaseInfoResponse() {
        return new GetPurchaseInfoResponse();
    }

    /**
     * Create an instance of {@link GetTotalPrice }
     * 
     */
    public GetTotalPrice createGetTotalPrice() {
        return new GetTotalPrice();
    }

    /**
     * Create an instance of {@link GetTotalPriceResponse }
     * 
     */
    public GetTotalPriceResponse createGetTotalPriceResponse() {
        return new GetTotalPriceResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPurchaseInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "getPurchaseInfo")
    public JAXBElement<GetPurchaseInfo> createGetPurchaseInfo(GetPurchaseInfo value) {
        return new JAXBElement<GetPurchaseInfo>(_GetPurchaseInfo_QNAME, GetPurchaseInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPurchaseInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "getPurchaseInfoResponse")
    public JAXBElement<GetPurchaseInfoResponse> createGetPurchaseInfoResponse(GetPurchaseInfoResponse value) {
        return new JAXBElement<GetPurchaseInfoResponse>(_GetPurchaseInfoResponse_QNAME, GetPurchaseInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTotalPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "getTotalPrice")
    public JAXBElement<GetTotalPrice> createGetTotalPrice(GetTotalPrice value) {
        return new JAXBElement<GetTotalPrice>(_GetTotalPrice_QNAME, GetTotalPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTotalPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "getTotalPriceResponse")
    public JAXBElement<GetTotalPriceResponse> createGetTotalPriceResponse(GetTotalPriceResponse value) {
        return new JAXBElement<GetTotalPriceResponse>(_GetTotalPriceResponse_QNAME, GetTotalPriceResponse.class, null, value);
    }

}
