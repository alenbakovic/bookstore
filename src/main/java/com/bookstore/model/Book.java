package com.bookstore.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Book {
    private final String title;
    private final List<String> authors;
    private final int numberOfPages;
    private final String genre;
    private final String isbn;
}
