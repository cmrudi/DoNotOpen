/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorws_client;

/**
 *
 * @author cmrudi
 */
public class CalculatorWS_client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            int i = 3;
            int j = 4;
            int result = add(i, j);
            System.out.println("Result = " + result);
        }
        catch (Exception ex) {
            System.out.println("The error is : "+ex);
        }
    }

    private static int add(int i, int j) {
        org.me.calculatorws.CalculatorWebService_Service service = new org.me.calculatorws.CalculatorWebService_Service();
        org.me.calculatorws.CalculatorWebService port = service.getCalculatorWebServicePort();
        return port.add(i, j);
    }
    
}
