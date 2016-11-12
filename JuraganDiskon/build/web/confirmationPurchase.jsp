<%-- 
    Document   : confirmationPurchase
    Created on : Nov 8, 2016, 8:05:43 PM
    Author     : fazarafi
--%>
    <%-- start web service invocation --%><hr/>
    
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
        <title>JuraganDiskon</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="style.css" />
        <script type="text/javascript" src="validate.js"></script>
    </head>
    <body>
    <div class="lhs"></div>
    <div class="centre">
	<h1>Juragan<span>Diskon</span></h1>
	<br>
        <div id="centeredmenu" class="mati">
            <ul>
            <li><a class="mati" href="/JuraganDiskon/catalog.jsp">Catalog</a></li>
            <li><a class="mati" href="/JuraganDiskon/yourProduct.jsp">Your Product</a></li>
            <li><a class="mati" href="/JuraganDiskon/addProduct.jsp">Add Product</a></li>
            <li><a class="mati" href="#">Sales</a></li>
            <li><a class="mati" href="#">Purchase</a></li>
            </ul>
        </div>
        <!--HEADER BOTTOM BORDER-->
        <div class="width-100">
            <ul>
                <h4 class="hiUsername">Hi, username</h4>
                <div class="separator"></div>
                <button type="button" id="logoutButton" onclick="" >logout</button>
            </ul>
        </div>
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