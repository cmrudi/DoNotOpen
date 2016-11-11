/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.juragandiskon;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author fazarafi
 */
@WebService(serviceName = "ConfirmationPurchase")
public class ConfirmationPurchase {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTotalPrice")
    public String getTotalPrice(@WebParam(name = "qty") int qty) {
        //TODO write your implementation code here:
        return null;
    }
}
