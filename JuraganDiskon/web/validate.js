/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validateRegisterForm() {
	var fullNameAlert,usernameAlert,emailAlert,passwordAlert,confirmAlert,fullAddressAlert,postalCodeAlert,phoneNumberAlert;
	var fullName = document.forms["registerForm"]["fullname"].value;
	var username = document.forms["registerForm"]["username"].value;
	var email = document.forms["registerForm"]["email"].value;
	var password = document.forms["registerForm"]["password"].value;
	var confirm = document.forms["registerForm"]["confirm"].value;
	var fullAddress = document.forms["registerForm"]["fulladdress"].value;
	var postalCode = document.forms["registerForm"]["postalcode"].value;
	var phoneNumber = document.forms["registerForm"]["phonenumber"].value;
	var result = true;


	var testEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	
	
	if (fullName == null || fullName == "") {
		fullNameAlert = "Full Name must be filled out";
		result = false;
		document.getElementById("fullNameAlert").innerHTML = fullNameAlert;
	}
	else {
		fullNameAlert = "";
		document.getElementById("fullNameAlert").innerHTML = fullNameAlert;
	}
	
	
	if (username == null || username == "") {
		usernameAlert = "Username must be filled out";
		result = false;
		document.getElementById("usernameAlert").innerHTML = usernameAlert;
	}
	else {
		usernameAlert = "";
		document.getElementById("usernameAlert").innerHTML = usernameAlert;
	}
	
	
	if (email == null || email == "") {
		emailAlert ="Email must be filled out";
		result = false;
		document.getElementById("emailAlert").innerHTML = emailAlert;
	}
	else if (!testEmail.test(email)) {
		emailAlert = "Please type the right email form";
		result = false;
		document.getElementById("emailAlert").innerHTML = emailAlert;
	}
	else {
		emailAlert = "";
		document.getElementById("emailAlert").innerHTML = emailAlert;
	}
	
	
	
	if (password == null || password == "") {
		passwordAlert = "Password must be filled out";
		result = false;
		document.getElementById("passwordAlert").innerHTML = passwordAlert;
	}
	else {
		passwordAlert = "";
		document.getElementById("passwordAlert").innerHTML = passwordAlert;	
	}
	
	if (confirm == null || confirm == "") {
		confirmAlert = "Confirm Password must be filled out";
		result = false;
		document.getElementById("confirmAlert").innerHTML = confirmAlert;
	}
	else if (confirm!=password) {
		confirmAlert = "Password and confirmation password are different";
		result = false;
		document.getElementById("confirmAlert").innerHTML = confirmAlert;
	}
	else {
		confirmAlert = "";
		document.getElementById("confirmAlert").innerHTML = confirmAlert;
	}
	
	if (fullAddress == null || fullAddress == "") {
		fullAddressAlert = "Full Address must be filled out";
		result = false;
		document.getElementById("fullAddressAlert").innerHTML = fullAddressAlert;
	}
	else {
		fullAddressAlert = "";
		document.getElementById("fullAddressAlert").innerHTML = fullAddressAlert;
	}
	
	if (postalCode == null || postalCode == "") {
		postalCodeAlert = "Postal code must be filled out";
		result = false;
		document.getElementById("postalCodeAlert").innerHTML = postalCodeAlert;
	}
	else {
		postalCodeAlert = "";
		document.getElementById("postalCodeAlert").innerHTML = postalCodeAlert;
	}
	
	if (phoneNumber == null || phoneNumber == "") {
		phoneNumberAlert = "Phone Number must be filled out";
		result = false;
		document.getElementById("phoneNumberAlert").innerHTML = phoneNumberAlert;
	}
	else {
		phoneNumberAlert = "";
		document.getElementById("phoneNumberAlert").innerHTML = phoneNumberAlert;
	}
	
	
	return result;
	
}



function validateLoginForm() {
	var usernameOrEmailAlert,passwordAlert = "";
	var password = document.forms["loginForm"]["password"].value;
	var usernameOrEmail = document.forms["loginForm"]["usernameOrEmail"].value;
	var result = true;
	
	if (usernameOrEmail == null || usernameOrEmail == "") {
		usernameOrEmailAlert = "Username or email must be filled out";
		result = false;
		document.getElementById("usernameOrEmailAlert").innerHTML = usernameOrEmailAlert;
	}
	else {
		usernameOrEmailAlert = "";
		document.getElementById("usernameOrEmailAlert").innerHTML = usernameOrEmailAlert;
	}
	
	if (password == null || password == "") {
		passwordAlert = "Password must be filled out";
		result = false;
		document.getElementById("passwordAlert").innerHTML = passwordAlert;
	}
	else {
		passwordAlert = "";
		document.getElementById("passwordAlert").innerHTML = passwordAlert;
	}
	
	return result;
}


function cancelAddProduct() {
	document.forms["addProductForm"]["productName"].value = "";
	document.forms["addProductForm"]["productPrice"].value = "";
	document.getElementById('productDescription').value = "";
}

function isInteger(x) {
        return x % 1 === 0;
    }

function validateAddProductForm() {
	var productNameAlert, productDescriptionAlert, productPriceAlert = "";
	var productName = document.forms["addProductForm"]["productName"].value;
	var productPrice = document.forms["addProductForm"]["productPrice"].value;
	var productDescription = document.getElementById('productDescription').value;
	
	result = true;
	
	if (productName == null || productName == "") {
		productNameAlert = "Product name must be filled out";
		result = false;
		document.getElementById("productNameAlert").innerHTML = productNameAlert;
	}
	else {
		productNameAlert = "";
		document.getElementById("productNameAlert").innerHTML = productNameAlert;
	}
	
	if (productPrice == null || productPrice == "") {
		productPriceAlert = "Product price must be filled out";
		result = false;
		document.getElementById("productPriceAlert").innerHTML = productPriceAlert;
	}
	else if (!isInteger(productPrice)) {
		productPriceAlert = "Product price must be integer";
		result = false;
		document.getElementById("productPriceAlert").innerHTML = productPriceAlert;
	}
	else {
		productPriceAlert = "";
		document.getElementById("productPriceAlert").innerHTML = productPriceAlert;
	}
	
	if (productDescription == null || productDescription == "") {
		productDescriptionAlert = "Description name must be filled out";
		result = false;
		document.getElementById("productDescriptionAlert").innerHTML = productDescriptionAlert;
	}
	else if (productDescription.length > 200) {
		productDescriptionAlert = "Description name must be less than 200 chars";
		result = false;
		document.getElementById("productDescriptionAlert").innerHTML = productDescriptionAlert;
	}
	else {
		productDescriptionAlert = "";
		document.getElementById("productDescriptionAlert").innerHTML = productDescriptionAlert;
	}

	var productImage = document.getElementById("file").files.length;
	var productImageAlert = "";
	if (productImage == 0) {
		productImageAlert = "Please choose an image";
		result = false;
		document.getElementById("productImageAlert").innerHTML = productImageAlert;
	}
	else {
		productImageAlert = "";
		document.getElementById("productImageAlert").innerHTML = productImageAlert;
	}
	
	

	return result;
	
}

function validateSearchForm() {
	var inputTextAlert = radioAlert = radio= "";
	var inputText = document.forms["searchForm"]["searchItem"].value;
	var radio = document.forms["searchForm"]["searchChoice"].value;

	var result = true;
	var i = 0;
	
	if (inputText == null || inputText == "") {
		inputTextAlert = "Search key must be filled out";
		result = false;
		document.getElementById("inputTextAlert").innerHTML = inputTextAlert;
	}
	else {
		inputTextAlert = "";
		document.getElementById("inputTextAlert").innerHTML = inputTextAlert;
	}



	if (radio == "product" || radio == "store") {
		inputTextAlert = "";
		document.getElementById("radioAlert").innerHTML = radioAlert;

	}
	else {

		radioAlert = "Please choose one search option";
		result = false;
		document.getElementById("radioAlert").innerHTML = radioAlert;
	}



	return result;

}


function validatePurchase() {
	var cardAlert,verifAlert,fullNameAlert,fullAddressAlert,postalCodeAlert,phoneNumberAlert = "";
	
	var creditcard = document.forms["purchaseForm"]["creditcard"].value;
	var verifnum = document.forms["purchaseForm"]["verifnum"].value;
	var fullName = document.forms["purchaseForm"]["fullname"].value;
	var fulladdress = document.forms["purchaseForm"]["fulladdress"].value;
	var postalcode = document.forms["purchaseForm"]["postalcode"].value;
	var phonenumber = document.forms["purchaseForm"]["phonenumber"].value;
	var creditCard = document.getElementById('creditcard').value;
	var verifNum = document.getElementById('verifnum').value;
	

	var result = true;

	var numVerifRegex = /^[0-9]*$/;

	//fullname verification
	if (fullName == null || fullName =="" ) {
		fullNameAlert = "required";
		result = false;
		document.getElementById("fullNameAlert").innerHTML = fullNameAlert;
	}
	else {
		fullNameAlert = "";
		document.getElementById("fullNameAlert").innerHTML = fullNameAlert;		
	}

	//fulladdress verification
	if (fulladdress == null || fulladdress =="" ) {
		fullAddressAlert = "required";
		result = false;
		document.getElementById("fullAddressAlert").innerHTML = fullAddressAlert;
	}
	else {
		fullAddressAlert = "";
		document.getElementById("fullAddressAlert").innerHTML = fullAddressAlert;		
	}

	//postalcode verification
	if (postalcode == null || postalcode =="" ) {
		postalCodeAlert = "required";
		result = false;
		document.getElementById("postalCodeAlert").innerHTML = postalCodeAlert;
	}
	else {
		postalCodeAlert = "";
		document.getElementById("postalCodeAlert").innerHTML = postalCodeAlert;		
	}

	//phonenumber verification
	if (phonenumber == null || phonenumber =="" ) {
		phoneNumberAlert = "required";
		result = false;
		document.getElementById("phoneNumberAlert").innerHTML = phoneNumberAlert;
	}
	else {
		phoneNumberAlert = "";
		document.getElementById("phoneNumberAlert").innerHTML = phoneNumberAlert;		
	}
	
	//creditcard verification
	if (creditCard == null || creditCard =="" ) {
		cardAlert = "required";
		result = false;
		document.getElementById("cardAlert").innerHTML = cardAlert;
	}
	else if (!numVerifRegex.test(creditCard)) {
		cardAlert = "number only";
		result = false;
		document.getElementById("cardAlert").innerHTML = cardAlert;	
	}
	else if (creditCard.length !== 12) {
		cardAlert = "must be 12 digits";
		result = false;
		document.getElementById("cardAlert").innerHTML = cardAlert;	
	}
	else {
		cardAlert = "";
		document.getElementById("cardAlert").innerHTML = cardAlert;		
	}

	//verifnum verification
	if (verifNum == null || verifNum =="" ) {
		verifAlert = "required";
		result = false;
		document.getElementById("verifAlert").innerHTML = verifAlert;
	}
	else if (!numVerifRegex.test(verifNum)) {
		verifAlert = "number only";
		result = false;
		document.getElementById("verifAlert").innerHTML = verifAlert;	
	}
	else if (verifNum.length !== 3) {
		verifAlert = "must be 3 digits";
		result = false;
		document.getElementById("verifAlert").innerHTML = verifAlert;	
	}

	else {
		verifAlert = "";
		document.getElementById("verifAlert").innerHTML = verifAlert;		
	}

	if (result) {
		return confirmPurchasePopUp();
	}


	else return result;
}

function deleteProductPopUp() {
    var retVal = confirm("Are you sure to delete this?");
	
	if( retVal == true ){
    	return true;
   	}
   	else{
    	return false;
   	}
}

function confirmPurchasePopUp() {
    var retVal = confirm("Are you sure about the data?");
	
	if( retVal == true ){
    	return true;

   	}
   	else{
    	return false;
   	}
}

function printPrice(harga) {
	var temp = harga.toString();
	var s = "";
	while (temp.length>3) {
		if  (s=="") {
			s = temp.substr(temp.length-3,3);
		}
		else { 
			var str = temp.substr(temp.length-3,3);
			str = str.concat(".");
			s = str.concat(s);
			

		}
		temp = temp.substr(0,temp.length-3);
	}
	if (s!==""){
		var st = temp.concat(".");
		s = st.concat(s);
		return s;
	}
	else { 
		return temp;
	}
}

function countTotalPrice() {

	var prc = document.getElementById("hiddenPrice").value;
	var q = document.getElementById("qty").value;
	document.getElementById("total").innerHTML = printPrice(q*prc);
	document.getElementById("init").innerHTML = "";
		
}

function pushLike(id,productId) {
	var text = document.getElementById("likeButton"+productId).textContent;
	var like = document.getElementById("totalLikes-"+productId).innerHTML;
	like = like.substr(0,1);
	like = parseInt(like);
	//var numLike = parseInt(textLike[0]);
	//var x = numLike.toString();
	var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
        	if (text == "Like") { //I.S Like, F.S Liked
        		like = like + 1;
            	document.getElementById("likeButton"+productId).innerHTML = "Liked";
            	document.getElementById("totalLikes-"+productId).innerHTML = like+" likes";
            	document.getElementById("likeButton"+productId).className = "likedButton";
            }
            else { //I.S Liked, F.S Like
            	like = like - 1;
            	document.getElementById("likeButton"+productId).innerHTML = "Like";
            	document.getElementById("totalLikes-"+productId).innerHTML = like+" likes";
            	document.getElementById("likeButton"+productId).className = "likeButton";
            }
        }
    }
    xmlhttp.open("GET", "like.php?id="+id+","+productId, true);
    xmlhttp.send();

}

