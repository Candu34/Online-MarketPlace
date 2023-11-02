<!DOCTYPE html>
<html>
<body>

<h1>Market Place </h1>
<hr>
<h4>Admin panel</h4>

<table border = "1">
    <tr>
        <th>Email: </th>
        <th>Name: </th>
        <th>Phone Number: </th>
        <th>Active: </th>
        <th>Role: </th>
        <th>Ban user: </th>
        <th>Redaction: </th>
        <th>Info: </th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email} </th>
            <th>${user.name} </th>
            <th>${user.phoneNumber} </th>
            <th><#if user.active><i>Activ</i><#else ><i>Inactive</i></#if></th>
            <th><#list user.roles as role>
                ${role}
            </#list></th>
            <th><form action="admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Ban User">
                </form></th>
            <th><a href="admin/user/edit/${user.id}">Redacting...</a></th>
            <th><a href="/user/${user.id}">Details...</a></th>
        </tr>
        <#else >
        <h3>There is no users</h3>
    </#list>
</table>


</body>
</html>