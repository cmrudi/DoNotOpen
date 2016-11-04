<%-- 
    Document   : catalog
    Created on : Nov 3, 2016, 8:51:39 PM
    Author     : cmrudi
--%>
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
        <h2>What are you going to buy today?</h2>
            <hr><br><br>
            <form name="searchForm" action="" onsubmit="return validateSearchForm()" method = "POST">
                <p id="inputTextAlert"></p>
                <p id="radioAlert"></p>
                <div id="searchItem" >
                        <input type = "text"  name = "searchItem">

                </div>
                <div id="submitSearchItem">
                        <input type="submit" id="searchItemSubmitButton" value="Go">
                </div><br>
                <p>by</p>
                <input type="radio" id="searchChoice1" name="searchChoice" value="product"> Product<br>
                <input type="radio" id="searchChoice2" name="searchChoice" value="store"> Store<br><br><br>
            </form>
            
            
            <p>storename uplodad at</p>
            <hr>
            <div>
                <div class="left-container"><img id="catalogImage" src="img/drawingbook.png"></div>
                <div class="mid-container">
                    <p><b>productName</b><br>IDR price<br>description</p>
                </div>
                <div class="right-container">
                    <br><p id="totalLikes"> likes</p>
                    <p> purchases<br></p>
                      <button type="button" class="likeButton" id="likeButton">Like</button>
                      <button type="button" id="buyButton" onclick="">Buy</button>
                </div>
            </div>
            <br>
            <hr>
            <br><br>
    </div>
    <div class="rhs"></div>
    </body>
</html>

