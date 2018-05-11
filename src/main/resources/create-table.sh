CREATE TABLE books (
    book_id          serial PRIMARY KEY,
    title            text,
    authors          text ARRAY,
    numberOfPages    integer,
    genre            text,
    isbn             text
);


INSERT INTO books (title, authors, numberofpages, genre, isbn)
    VALUES ('Na Drini cuprija',
            '{"Ivo Andric", "Ivo Andric"}',
            10,
            'Neki zanr',
            'Neki isbn');

CREATE TABLE books (
    title            text,
    authors          text ARRAY,
    numberOfPages    integer,
    genre            text,
    isbn             text
);
