CREATE TABLE books (
   id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   title VARCHAR(255) NOT NULL,
   author VARCHAR(100) NOT NULL,
   release_year INT NOT NULL,

   CONSTRAINT title_abd_author UNIQUE (title, author)
);