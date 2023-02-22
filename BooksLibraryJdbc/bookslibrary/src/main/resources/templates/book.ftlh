<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Карточка книги</title>
</head>
<body>
<div>${book.title}, ${book.author}, #{book.yearOfWriting}</div>
<br>
<#if book.borrowerId == 0>
    <div>Эта книга свободна. Кому её назначить?</div>
    <div>Выберите человека</div>
    <form action="/books/${book.id}/updateBorrower" method="post">
        <select name="newBorrower">
                <#list people as person>
                    <option>${person.fullName}</option>
                </#list>
            </select>
        <p><input type="submit" value="Назначить книгу"></p>
    </form>
<#else>
    <div>Книга сейчас у: ${borrower.fullName}</div>
    <form method="post" action="/books/${book.id}/free-up">
        <button>Освободить книгу</button>
    </form>
</#if>
<hr>
<form action="/books/${book.id}/edit">
    <button>Редактировать</button>
</form>
<form method="post" action="/books/${book.id}/delete">
    <button>Удалить</button>
</form>
</body>
</html>