package com.bookstore.dao.mappers;

import com.bookstore.model.Book;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class BookMapper implements ResultSetMapper<Book> {
    @Override
    public Book map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return Book.builder()
                .title(resultSet.getString("title"))
                .numberOfPages(resultSet.getInt("numberofpages"))
                .genre(resultSet.getString("genre"))
                .isbn(resultSet.getString("isbn"))
                .build();
    }

}
