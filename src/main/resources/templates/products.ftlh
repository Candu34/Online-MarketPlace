<!DOCTYPE html>
<html>
<body>

<h1>Market Place | <a href="/login">Login</a></h1><hr>

<form action="/" method="get">
    Search products by name <input type="text" name="title"><br>
    <input type="submit" value="Search!">
</form>

<#list products as product>
    <div>
        <p><b>${product.title}</b></p>
        <p>${product.price}  usd.| <a href="/product/${product.id}">Details...</a></p>
    </div>
<hr>
    <#else >
    <h3>There is no products added yet!</h3>
</#list>


 <h3>Add new product</h3>
    <form action="/product/create" method="post" enctype="multipart/form-data">
        Title of product: <input type="text" name = "title"><br><br>
        Description: <input type="text" name = "description"><br><br>
        Price: <input type="number" name = "price"><br><br>
        City: <input type="text" name = "city"><br><br>
        Add photo: <input type="file" name = "files" multiple><br><br>

        <input type="submit" value="Add product">
    </form>



</body>
</html>