<!DOCTYPE html>
<html>
<head>Market Place</head>
<body>
<h1>Market Place</h1>
<h4>Registration</h4>
<form action="/registration" method="post">
    User Name: <input type="text" name="name"><br><br>
    Email: <input type="email" name="email"><br><br>
    Phone nomber: <input type="text" name="phoneNumber"><br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Register"/>
</form>
<#if errorMessage??>
    <h2 style = "color: red">${errorMessage}</h2>
</#if>
</body>