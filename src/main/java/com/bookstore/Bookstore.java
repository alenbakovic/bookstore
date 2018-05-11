package com.bookstore;

import com.bookstore.configuration.BookstoreConfiguration;
import com.bookstore.dao.BookDAO;
import com.bookstore.resource.BookstoreResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bookstore extends Application<BookstoreConfiguration> {

    Logger log = LoggerFactory.getLogger(Bookstore.class);

    public static void main(String[] args) throws Exception {
        new Bookstore().run(args);
    }

    @Override
    public void initialize(Bootstrap<BookstoreConfiguration> bootstrap) {
    }

    @Override
    public void run(BookstoreConfiguration bookstoreConfiguration, Environment environment) throws Exception {

        log.info("Configuring postgresql database...");
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, bookstoreConfiguration.getDatabase(), "postgresql");
        final BookDAO bookDAO = jdbi.onDemand(BookDAO.class);

        log.info("Registering resources...");
        environment.jersey().register(new BookstoreResource(bookDAO));
    }
}
