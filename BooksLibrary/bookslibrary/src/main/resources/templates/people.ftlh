<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>People</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>FullName</th>
        <th>YearOfBirth</th>
    </tr>
    <#list people as person>
        <tr>
            <td>${person.id}</td>
            <td>${person.fullName}</td>
            <td>${person.yearOfBirth}</td>
        </tr>
    </#list>
</table>
</body>
</html>