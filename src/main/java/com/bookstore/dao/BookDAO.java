package com.bookstore.dao;

import com.bookstore.dao.mappers.BookMapper;
import com.bookstore.model.Book;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(BookMapper.class)
public interface BookDAO {
    @SqlUpdate("INSERT INTO books (title, numberofpages, genre, isbn) " +
            "VALUES (:title, :numberOfPages, :genre, :isbn)")
    void addBook(@BindBean Book book);

    @SqlQuery("SELECT * FROM books WHERE isbn = :isbn")
    Book getBookByISBN(@Bind("isbn") String isbn);
}
