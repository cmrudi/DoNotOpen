
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

    private final static QName _GetEditingProdInfo_QNAME = new QName("http://juragandiskon.me.com/", "getEditingProdInfo");
    private final static QName _GetEditingProdInfoResponse_QNAME = new QName("http://juragandiskon.me.com/", "getEditingProdInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.me.juragandiskon
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEditingProdInfo }
     * 
     */
    public GetEditingProdInfo createGetEditingProdInfo() {
        return new GetEditingProdInfo();
    }

    /**
     * Create an instance of {@link GetEditingProdInfoResponse }
     * 
     */
    public GetEditingProdInfoResponse createGetEditingProdInfoResponse() {
        return new GetEditingProdInfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEditingProdInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "getEditingProdInfo")
    public JAXBElement<GetEditingProdInfo> createGetEditingProdInfo(GetEditingProdInfo value) {
        return new JAXBElement<GetEditingProdInfo>(_GetEditingProdInfo_QNAME, GetEditingProdInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEditingProdInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "getEditingProdInfoResponse")
    public JAXBElement<GetEditingProdInfoResponse> createGetEditingProdInfoResponse(GetEditingProdInfoResponse value) {
        return new JAXBElement<GetEditingProdInfoResponse>(_GetEditingProdInfoResponse_QNAME, GetEditingProdInfoResponse.class, null, value);
    }

}
