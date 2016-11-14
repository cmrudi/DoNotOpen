
package com.me.juragandiskon;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "YourProduct", targetNamespace = "http://juragandiskon.me.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface YourProduct {


    /**
     * 
     * @param productId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteProduct", targetNamespace = "http://juragandiskon.me.com/", className = "com.me.juragandiskon.DeleteProduct")
    @ResponseWrapper(localName = "deleteProductResponse", targetNamespace = "http://juragandiskon.me.com/", className = "com.me.juragandiskon.DeleteProductResponse")
    @Action(input = "http://juragandiskon.me.com/YourProduct/deleteProductRequest", output = "http://juragandiskon.me.com/YourProduct/deleteProductResponse")
    public String deleteProduct(
        @WebParam(name = "product_id", targetNamespace = "")
        int productId);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws IOException_Exception
     * @throws MalformedURLException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "validateAccessToken", targetNamespace = "http://juragandiskon.me.com/", className = "com.me.juragandiskon.ValidateAccessToken")
    @ResponseWrapper(localName = "validateAccessTokenResponse", targetNamespace = "http://juragandiskon.me.com/", className = "com.me.juragandiskon.ValidateAccessTokenResponse")
    @Action(input = "http://juragandiskon.me.com/YourProduct/validateAccessTokenRequest", output = "http://juragandiskon.me.com/YourProduct/validateAccessTokenResponse", fault = {
        @FaultAction(className = MalformedURLException_Exception.class, value = "http://juragandiskon.me.com/YourProduct/validateAccessToken/Fault/MalformedURLException"),
        @FaultAction(className = IOException_Exception.class, value = "http://juragandiskon.me.com/YourProduct/validateAccessToken/Fault/IOException")
    })
    public String validateAccessToken(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws IOException_Exception, MalformedURLException_Exception
    ;

    /**
     * 
     * @param accessToken
     * @return
     *     returns java.util.List<java.lang.String>
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProducts", targetNamespace = "http://juragandiskon.me.com/", className = "com.me.juragandiskon.GetProducts")
    @ResponseWrapper(localName = "getProductsResponse", targetNamespace = "http://juragandiskon.me.com/", className = "com.me.juragandiskon.GetProductsResponse")
    @Action(input = "http://juragandiskon.me.com/YourProduct/getProductsRequest", output = "http://juragandiskon.me.com/YourProduct/getProductsResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://juragandiskon.me.com/YourProduct/getProducts/Fault/IOException")
    })
    public List<String> getProducts(
        @WebParam(name = "access_token", targetNamespace = "")
        String accessToken)
        throws IOException_Exception
    ;

}