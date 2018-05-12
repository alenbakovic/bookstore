#!/bin/bash
printf "CREATING bookstore ROLE\n"
sudo -u postgres psql -c "CREATE USER bookstore WITH PASSWORD 'myPass';"

printf "CREATING bookstore DATABASE\n"
sudo -u postgres createdb bookstore

printf "CREATING books TABLE\n"
sudo -u postgres psql -d bookstore -c "CREATE TABLE books (
    title            text,
    authors          text,
    numberOfPages    integer,
    genre            text,
    isbn             text PRIMARY KEY
);"
printf "CHANGING books OWNER to bookstore\n"
sudo -u postgres psql -d bookstore -c "ALTER TABLE public.books OWNER TO bookstore;"




