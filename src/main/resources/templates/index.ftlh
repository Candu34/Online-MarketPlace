<!DOCTYPE html>
<html>
<body>

<h1>Market Place</h1><hr>
<#list products as product>
    <div>
        <p><b>${product.title}</b></p>
        <p>${product.city}  usd.| <a href="/product/${product.id}"></a>Details...</p>
    </div>
<hr>
</#list>

 <h3>Add new product</h3>
    <form action="/product/create" method="post">
        Title of product: <input type="text" name = "title"><br><br>
        Description: <input type="text" name = "description"><br><br>
        Price: <input type="number" name = "price"><br><br>
        City: <input type="text" name = "city"><br><br>
        Name od seller: <input type="text" name = "author"><br><br>
        <input type="submit" value="Add product">
    </form>



</body>
</html>