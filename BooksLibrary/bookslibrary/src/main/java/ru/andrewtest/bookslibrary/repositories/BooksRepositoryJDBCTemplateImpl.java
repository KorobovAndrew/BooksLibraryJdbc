package ru.andrewtest.bookslibrary.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.andrewtest.bookslibrary.models.Book;

import java.util.List;

@Component
public class BooksRepositoryJDBCTemplateImpl implements BooksRepository{

    //language=SQL
    private static final String SQL_GET_ALL_BOOKS = "select * from book";
    private final JdbcTemplate jdbcTemplateBook;

    public BooksRepositoryJDBCTemplateImpl (JdbcTemplate jdbcTemplateBook){
        this.jdbcTemplateBook = jdbcTemplateBook;
    }

    private static final RowMapper<Book> bookRowMapper = (row, rowNum) -> {
        int id = row.getInt("id");
        String title = row.getString("title");
        String author = row.getString("author");
        Integer yearOfWriting = row.getInt("yearOfWriting");
        //Integer borrowerId = row.getInt("borrowerId");
        return new Book(id, title, author, yearOfWriting);
    };
    @Override
    public List<Book> findAll() {
        return jdbcTemplateBook.query(SQL_GET_ALL_BOOKS, bookRowMapper);
    }
}
