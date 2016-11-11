<%-- 
    Document   : confirmationPurchase
    Created on : Nov 8, 2016, 8:05:43 PM
    Author     : fazarafi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    <h2>Please confirm your purchase</h2>
            <hr><br><br>

            <!--CONTAINER UPPER BORDER-->
            <form name="purchaseForm" action="" onsubmit="return validatePurchase()" method = "POST">
                Product 	: <?php echo $productName ?> 
                <br>
                Price	 	: IDR <?php echo printPrice($price) ?>

                <br>
                Quantity 	:<input type = "num" id="qty" name = "quantity" value ="1" onkeyup="return countTotalPrice()">

                <br>
                Total Price	: IDR <span id="total" value="<?php print printPrice($price) ?>"> </span>
                <span id="init" value=""><?php echo printPrice($price) ?></span>
                <input id="hiddenPrice" type="hidden" value="<?php echo $price ?>" >

                <br>
                Delivery To : 
                <br>
                <br>
                Consignee <br>
                <input type = "text" name = "fullname" value = "<?php echo $fullName ?>">
                <p id="fullNameAlert"></p><br>
                Full Address <br>

                <textarea name="fulladdress" id="fullAddress"  rows="4" cols="127" ><?php echo $fullAddress ?></textarea>
                <p class="warning" id="fullAddressAlert"></p><br>
                Postal Code <br>
                <input type = "text" name = "postalcode" value = "<?php echo $postalCode ?>">
                <p class="warning" id="postalCodeAlert"></p><br>
                Phone Number <br>
                <input type = "text" name = "phonenumber" value = "<?php echo $phoneNumber ?>">
                <p class="warning" id="phoneNumberAlert"></p><br>
                12 Digits Credit Card Number<br>
                <input type = "text" id = "creditcard" name = "creditcard">
                <p class="warning" id="cardAlert"></p><br>
                3 Digits Card Verification Value <br>
                <input type = "text" id = "verifnum" name = "verifnum">
                <p class="warning" id="verifAlert"></p><br>

                <input class="button-right-group" type="button" value="CANCEL" id="CANCEL" onclick="<?php print "location.href='".$getURL."catalog.php?id=".$id."';"?>">
                <input class="button-right-group" type="submit" name="confirm" value="CONFIRM">


            </form>


            <!--CONTAINER BOTTOM BORDER-->
	</div>
	</body>
</html>