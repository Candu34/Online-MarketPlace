<!DOCTYPE html>
<html>
<body>

<h1>Market Place </h1>
<hr>
<#if user.email??>
    <h3>User: <i>${user.name}</i></h3>
    <form action="/logout">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Logout">
    </form>
<#else><a href="/login">Login</a>
    <hr>
</#if>

<#if user.isAdmin()>
    <a href="/admin">Administrator panel</a>
</#if>


<form action="/" method="get">
    Search products by name <input type="text" name="title"><br>
    <input type="submit" value="Search!">
</form>

<#list products as product>
    <div>
        <p><b>${product.title}</b></p>
        <p>${product.price} usd.| <a href="/product/${product.id}">Details...</a></p>
    </div>
    <hr>
<#else >
    <h3>There is no products added yet!</h3>
</#list>

<#if user.email??>
    <h3>Add new product</h3>
    <form action="/product/create" method="post" enctype="multipart/form-data">
        Title of product: <input type="text" name="title"><br><br>
        Description: <input type="text" name="description"><br><br>
        Price: <input type="number" name="price"><br><br>
        City: <input type="text" name="city"><br><br>
        Add photo: <input type="file" name="files" multiple><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Add product">
    </form>

</#if>

</body>
</html>