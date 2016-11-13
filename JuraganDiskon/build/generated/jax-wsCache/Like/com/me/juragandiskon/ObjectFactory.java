
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
    private final static QName _Hello_QNAME = new QName("http://juragandiskon.me.com/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://juragandiskon.me.com/", "helloResponse");
    private final static QName _SetLike_QNAME = new QName("http://juragandiskon.me.com/", "setLike");
    private final static QName _SetLikeResponse_QNAME = new QName("http://juragandiskon.me.com/", "setLikeResponse");
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
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link SetLike }
     * 
     */
    public SetLike createSetLike() {
        return new SetLike();
    }

    /**
     * Create an instance of {@link SetLikeResponse }
     * 
     */
    public SetLikeResponse createSetLikeResponse() {
        return new SetLikeResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetLike }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "setLike")
    public JAXBElement<SetLike> createSetLike(SetLike value) {
        return new JAXBElement<SetLike>(_SetLike_QNAME, SetLike.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetLikeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://juragandiskon.me.com/", name = "setLikeResponse")
    public JAXBElement<SetLikeResponse> createSetLikeResponse(SetLikeResponse value) {
        return new JAXBElement<SetLikeResponse>(_SetLikeResponse_QNAME, SetLikeResponse.class, null, value);
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
