package ru.andrewtest.bookslibrary.forms;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto2 {
    private String title;
    private String author;
    private Integer yearOfWriting;
}
