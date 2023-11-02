<!DOCTYPE html>
<html>
<head>
    <title>Market Place</title>
</head>
<body>


<h1>Market Place</h1>
<h3>Redacting user: ${user.name}</h3>
<form action="/admin/user/edit" method="post">
    <#list roles as role>
        <div>
            <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}></label>
        </div>
    </#list>
    <input type="hidden" value="${user.id}" name="userId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <botton type="submit">Update</botton>
</form>




</body>
</html>