<!DOCTYPE html>
<html>
<head>Market Place</head>
<body>
<h1>Market Place</h1>
<h3>User info:</h3>
<b>Phone number: ${user.phoneNumber}</b><br>
<b>Email: ${user.email}</b>

<h4>${user.name} products:</h4>
<#list products as product>
    <div>
        <p><b>${product.title}</b></p>
        <p>${product.price} usd.| <a href="/product/${product.id}">Details...</a></p>
    </div>
    <hr>
    <#else >
    <h3>There is no products</h3>
</#list>
</body>