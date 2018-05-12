package com.bookstore.test.resources;

import com.bookstore.dao.BookDAO;
import com.bookstore.model.Book;
import com.bookstore.resource.BookstoreResource;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnitRunner;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/*
 * Unit test for {@link BookstoreResource}
 */
@RunWith(MockitoJUnitRunner.class)
public class BookstoreResourceTest {

    private static final BookDAO BOOK_DAO = mock(BookDAO.class);

    @ClassRule
    public static final ResourceTestRule RESOURCES = ResourceTestRule.builder()
            .addResource(new BookstoreResource(BOOK_DAO))
            .build();

    @Captor
    private ArgumentCaptor<Book> bookCaptor;

    private Book book;

    @Before
    public void setUp() {
        book = Book.builder()
                .title("The Bridge on the Drina - Na Drini cuprija")
                .authors("Ivo Andric")
                .numberOfPages(379)
                .genre("Historical fiction")
                .isbn("9788650526507")
                .build();
    }

    @After
    public void tearDown() {
        reset(BOOK_DAO);
    }

    @Test
    public void addBook() {
        doNothing().when(BOOK_DAO).addBook(any(Book.class));

        final Response response = RESOURCES.target("/bookstore/addBook")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(book, MediaType.APPLICATION_JSON_TYPE));

        verify(BOOK_DAO).addBook(bookCaptor.capture());
        assertThat(bookCaptor.getValue().getIsbn()).isEqualTo(book.getIsbn());
        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.OK);
    }

    @Test
    public void getBookByISBN() {
        when(BOOK_DAO.getBookByISBN(anyString())).thenReturn(book);

        Book responseBook = RESOURCES.target("/bookstore/getBook")
                .queryParam("isbn", "9788650526507")
                .request().get(Book.class);

        verify(BOOK_DAO).getBookByISBN(anyString());
        assertThat(responseBook.getIsbn()).isEqualTo(book.getIsbn());
    }

}
