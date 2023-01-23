<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>User${person.id}</title>
</head>
<body>
<div>${person.fullName}, #{person.yearOfBirth}</div>
<#if books?size == 0>
    <div>Человек пока не взял ни одной книги</div>
<#else>
    <hr>
    <div>Книги:</div>
    <#list books as book>
        <div>${book.title}, ${book.author}, #{book.yearOfWriting}</div>
    </#list>
</#if>
<hr>
<form action="/people/${person.id}/edit">
    <button>Редактировать</button>
</form>
<form method="post" action="/people/${person.id}/delete">
    <button>Удалить</button>
</form>
</body>
</html>