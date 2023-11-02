<!DOCTYPE html>
<html>
<head>
    <title>Market Place</title>
</head>
<body>


<h1>Market Place</h1>
<h4>Login</h4>
<div>

</div>

<form action = "/login" method="post">
    Email: <input type="email" name = "username"><br><br>
    Password: <input type="password" name = "password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Login">
</form>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
<a href="/registration">Register</a>
</body>
</html>