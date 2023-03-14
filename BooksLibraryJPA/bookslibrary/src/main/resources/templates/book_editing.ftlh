<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Редактирование карточки книги</title>
</head>
<body>
<form method="post" action="/books/${book.id}/edit">
    <label>Введите название книги:
        <input name="title" value="${book.title}">
    </label><br>
    <label>Введите автора:
        <input name="author" value="${book.author}">
    </label><br>
    <label>Введите год:
        <input name="yearOfWriting" value="#{book.yearOfWriting}">
    </label><br>
    <input type="submit" value="Редактировать!">
</form>
</body>
</html>