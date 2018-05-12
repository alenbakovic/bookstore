#!/bin/bash
printf "REMOVING bookstore ROLE\n"
sudo -u postgres psql -c "DROP USER bookstore;"

printf "REMOVING bookstore DATABASE\n"
sudo -u postgres psql -c "DROP DATABASE bookstore;"

