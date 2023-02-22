package ru.andrewtest.bookslibrary.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.andrewtest.bookslibrary.models.Book;

import java.util.List;

@Component
public class BookRepositoryJDBCTemplate implements BookRepository {

    //language=SQL
    private static final String SQL_GET_ALL_BOOKS = "select * from book";

    //language=SQL
    private static final String SQL_GET_BOOKS_BY_PERSON_ID = "select * from book where borrower_id = ?";

    //language=SQL
    private static final String SQL_ADD_BOOK = "insert into book(title, author, yearOfWriting) values (?, ?, ?)";

    //language=SQL
    private static final String SQL_FIND_BOOK_BY_ID = "select * from book where id = ?";

    //language=SQL
    private static final String SQL_UPDATE_BOOK = "update book set title = ?, author = ?, yearOfWriting = ? where id = ?";

    //language=SQL
    private static final String SQL_DELETE_BOOK_BY_ID = "delete from book where id = ?";
    //language=SQL
    private static final String SQL_SET_BORROWER_ID_TO_NULL = "update book set borrower_id = null where id = ?";

    //language=SQL
    private static final String SQL_UPDATE_BORROWER_ID_BY_BOOK_ID =
            "update book set borrower_id = (select id from person where fullname = ?) where id = ?";

    private final JdbcTemplate jdbcTemplateBook;

    public BookRepositoryJDBCTemplate(JdbcTemplate jdbcTemplateBook) {
        this.jdbcTemplateBook = jdbcTemplateBook;
    }

    private static final RowMapper<Book> bookRowMapper = (row, rowNum) -> {
        int id = row.getInt("id");
        String title = row.getString("title");
        String author = row.getString("author");
        Integer yearOfWriting = row.getInt("yearOfWriting");
        Integer borrowerId = row.getInt("borrower_id");
        return new Book(id, title, author, yearOfWriting, borrowerId);
    };

    @Override
    public List<Book> findAll() {
        return jdbcTemplateBook.query(SQL_GET_ALL_BOOKS, bookRowMapper);
    }

    @Override
    public List<Book> findBooksByPersonId(int personId) {
        return jdbcTemplateBook.query(SQL_GET_BOOKS_BY_PERSON_ID, bookRowMapper, personId);
    }

    @Override
    public void addBook(String title, String author, Integer yearOfWriting) {
        jdbcTemplateBook.update(SQL_ADD_BOOK, title, author, yearOfWriting);
    }

    @Override
    public Book findBookById(int bookId) {
        return jdbcTemplateBook.queryForObject(SQL_FIND_BOOK_BY_ID, bookRowMapper, bookId);
    }

    @Override
    public void updateBook(String title, String author, Integer yearOfWriting, int bookId) {
        jdbcTemplateBook.update(SQL_UPDATE_BOOK, title, author, yearOfWriting, bookId);
    }

    @Override
    public void deleteBookById(int bookId) {
        jdbcTemplateBook.update(SQL_DELETE_BOOK_BY_ID, bookId);
    }

    @Override
    public void deleteLinkOnPerson(int bookId) {
        jdbcTemplateBook.update(SQL_SET_BORROWER_ID_TO_NULL, bookId);
    }

    @Override
    public void updateBorrowerId(String newBorrower, int bookId) {
        jdbcTemplateBook.update(SQL_UPDATE_BORROWER_ID_BY_BOOK_ID, newBorrower, bookId);
    }
}
