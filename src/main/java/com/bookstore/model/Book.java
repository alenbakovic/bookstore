package com.bookstore.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Book {
    private final String title;
    private final String authors;
    private final int numberOfPages;
    private final String genre;
    private final String isbn;
}
