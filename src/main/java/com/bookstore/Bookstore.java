package com.bookstore;

import com.bookstore.configuration.BookstoreConfiguration;
import com.bookstore.dao.BookDAO;
import com.bookstore.resource.BookstoreResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class Bookstore extends Application<BookstoreConfiguration> {

    public static void main(String[] args) throws Exception {
        System.out.println("Starting Bookstore service...");
        new Bookstore().run(args);
    }

    @Override
    public void initialize(Bootstrap<BookstoreConfiguration> bootstrap) {
    }

    @Override
    public void run(BookstoreConfiguration bookstoreConfiguration, Environment environment) throws Exception {
        final String name = bookstoreConfiguration.getName();
        System.out.println(name);

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, bookstoreConfiguration.getDatabase(), "postgresql");

        final BookDAO bookDAO = jdbi.onDemand(BookDAO.class);

        environment.jersey().register(new BookstoreResource(bookDAO));
    }
}
