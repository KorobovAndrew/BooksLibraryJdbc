<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Books</title>
</head>
<body>
<p>
    <#list books as book>
        ${book.title}, ${book.author}, ${book.yearOfWriting}<br>
    </#list>
</p>
<hr>
Добавить книгу
</body>
</html>