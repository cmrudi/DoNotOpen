
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
    private final static QName _EditTheProduct_QNAME = new QName("http://juragandiskon.me.com/", "editTheProduct");
    private final static QName _EditTheProductResponse_QNAME = new QName("http://juragandiskon.me.com/", "editTheProductResponse");
    private final static QName _GetEditingProdInfo_QNAME = new QName("http://juragandiskon.me.com/", "getEditingProdInfo");
    private final static QName _GetEditingProdInfoResponse_QNAME = new QName("http://juragandiskon.me.com/", "getEditingProdInfoResponse");
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
     * Create an instance of {@link EditTheProduct }
     * 
     */
    public EditTheProduct createEditTheProduct() {
        return new EditTheProduct();
    }

    /**
     * Create an instance of {@link EditTheProductResponse }
     * 
     */
    public EditTheProductResponse createEditTheProductResponse() {
        return new EditTheProductResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EditTheProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "editTheProduct")
    public JAXBElement<EditTheProduct> createEditTheProduct(EditTheProduct value) {
        return new JAXBElement<EditTheProduct>(_EditTheProduct_QNAME, EditTheProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditTheProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "editTheProductResponse")
    public JAXBElement<EditTheProductResponse> createEditTheProductResponse(EditTheProductResponse value) {
        return new JAXBElement<EditTheProductResponse>(_EditTheProductResponse_QNAME, EditTheProductResponse.class, null, value);
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
