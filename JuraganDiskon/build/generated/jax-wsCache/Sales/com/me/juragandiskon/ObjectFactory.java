
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

    private final static QName _IOException_QNAME = new QName("http://juragandiskon.me.com/", "IOException");
    private final static QName _MalformedURLException_QNAME = new QName("http://juragandiskon.me.com/", "MalformedURLException");
    private final static QName _GetSales_QNAME = new QName("http://juragandiskon.me.com/", "getSales");
    private final static QName _GetSalesResponse_QNAME = new QName("http://juragandiskon.me.com/", "getSalesResponse");
    private final static QName _ValidateAccessToken_QNAME = new QName("http://juragandiskon.me.com/", "validateAccessToken");
    private final static QName _ValidateAccessTokenResponse_QNAME = new QName("http://juragandiskon.me.com/", "validateAccessTokenResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.me.juragandiskon
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link MalformedURLException }
     * 
     */
    public MalformedURLException createMalformedURLException() {
        return new MalformedURLException();
    }

    /**
     * Create an instance of {@link GetSales }
     * 
     */
    public GetSales createGetSales() {
        return new GetSales();
    }

    /**
     * Create an instance of {@link GetSalesResponse }
     * 
     */
    public GetSalesResponse createGetSalesResponse() {
        return new GetSalesResponse();
    }

    /**
     * Create an instance of {@link ValidateAccessToken }
     * 
     */
    public ValidateAccessToken createValidateAccessToken() {
        return new ValidateAccessToken();
    }

    /**
     * Create an instance of {@link ValidateAccessTokenResponse }
     * 
     */
    public ValidateAccessTokenResponse createValidateAccessTokenResponse() {
        return new ValidateAccessTokenResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MalformedURLException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "MalformedURLException")
    public JAXBElement<MalformedURLException> createMalformedURLException(MalformedURLException value) {
        return new JAXBElement<MalformedURLException>(_MalformedURLException_QNAME, MalformedURLException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSales }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "getSales")
    public JAXBElement<GetSales> createGetSales(GetSales value) {
        return new JAXBElement<GetSales>(_GetSales_QNAME, GetSales.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSalesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "getSalesResponse")
    public JAXBElement<GetSalesResponse> createGetSalesResponse(GetSalesResponse value) {
        return new JAXBElement<GetSalesResponse>(_GetSalesResponse_QNAME, GetSalesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateAccessToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "validateAccessToken")
    public JAXBElement<ValidateAccessToken> createValidateAccessToken(ValidateAccessToken value) {
        return new JAXBElement<ValidateAccessToken>(_ValidateAccessToken_QNAME, ValidateAccessToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateAccessTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "validateAccessTokenResponse")
    public JAXBElement<ValidateAccessTokenResponse> createValidateAccessTokenResponse(ValidateAccessTokenResponse value) {
        return new JAXBElement<ValidateAccessTokenResponse>(_ValidateAccessTokenResponse_QNAME, ValidateAccessTokenResponse.class, null, value);
    }

}
