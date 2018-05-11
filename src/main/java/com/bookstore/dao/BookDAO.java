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
    @SqlUpdate("INSERT INTO books (title, numberofpages, genre, isbn, authors) " +
            "VALUES (:title, :numberOfPages, :genre, :isbn, :authors)")
    int addBook(@BindBean Book book);

    @SqlQuery("SELECT * FROM books WHERE book_id = :id")
    Book getBookById(@Bind("id") int id);
}
