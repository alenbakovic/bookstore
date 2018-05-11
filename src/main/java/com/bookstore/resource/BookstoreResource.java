package com.bookstore.resource;

import com.bookstore.dao.BookDAO;
import com.bookstore.model.Book;
import com.google.common.base.Optional;
import lombok.AllArgsConstructor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bookstore")
@Produces(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class BookstoreResource {

    private final BookDAO bookDAO;

    @POST
    @Path("/addBook")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBook(Book book) {
        bookDAO.addBook(book);
        return Response.ok().build();
    }

    @GET
    @Path("/getBook")
    public Book getBook(@QueryParam("bookId") Optional<Integer> bookId) {
        return bookDAO.getBookById(bookId.or(Integer.valueOf(1)));
    }

}
