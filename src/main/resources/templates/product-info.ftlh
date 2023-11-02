<!DOCTYPE html>
<html>
<body>

<h1>Market Place</h1><hr>
<h3>Info about the product</h3>

<#list product.images as image>
    <img src="/images/${image.id}">
   <br><br>
</#list> 


<b>Name: ${product.title}</b>
<b>Description: ${product.description}</b>
<b>Price: ${product.price}</b>
<b>City: ${product.city}</b>
<b>Author: ${product.user.name}</b>
<b>Phone number: ${product.user.phoneNumber}</b>
<b>Seller: <a href="/user/{product.user.id}">${product.user.name}</a></b>

<hr>



</body>
</html>