<!DOCTYPE html>
<html>
<body>

<h1>Market Place</h1><hr>
<h3>Info about the product</h3>
<b>Name: ${product.title}</b>
<b>Description: ${product.description}</b>
<b>Price: ${product.price}</b>
<b>City: ${product.city}</b>
<b>Author: ${product.author}</b>


<hr>

    <form action="/product/delete/${product.id}" method="post">

        <input type="submit" value="Delete product">
    </form>



</body>
</html>