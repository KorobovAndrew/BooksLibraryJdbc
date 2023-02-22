package ru.andrewtest.bookslibrary.factories;

import ru.andrewtest.bookslibrary.forms.BookDto1;
import ru.andrewtest.bookslibrary.forms.BookDto2;
import ru.andrewtest.bookslibrary.models.Book;

public class BookDtoFactory {
    public static BookDto1 createBookDto1(Book book){
        return BookDto1.builder()
                .title(book.getTitle())
                .id(book.getId())
                .author(book.getAuthor())
                .yearOfWriting(book.getYearOfWriting())
                .build();
    }

    public static BookDto2 createBookDto2(Book book){
        return BookDto2.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .yearOfWriting(book.getYearOfWriting())
                .build();
    }
}
