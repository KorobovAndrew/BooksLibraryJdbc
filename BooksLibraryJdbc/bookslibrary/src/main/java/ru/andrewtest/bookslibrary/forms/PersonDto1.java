package ru.andrewtest.bookslibrary.forms;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto1 {
    private String fullName;
    private Integer yearOfBirth;
}