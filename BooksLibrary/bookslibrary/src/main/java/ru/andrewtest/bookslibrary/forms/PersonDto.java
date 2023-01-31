package ru.andrewtest.bookslibrary.forms;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto {
    private String fullName;
    private Integer yearOfBirth;
}