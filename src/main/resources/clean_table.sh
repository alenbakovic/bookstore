#!/bin/bash
printf "CLEANING TABLE books FROM bookstore DATABASE\n"
sudo -u postgres psql -d bookstore -c "DELETE FROM books;"
