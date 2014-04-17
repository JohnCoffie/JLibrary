-- Table: users

-- DROP TABLE users;

CREATE TABLE users
(
  user_id integer NOT NULL,
  name character(50) NOT NULL,
  birthday date,
  sex bit(1),
  password character(30) NOT NULL DEFAULT 123,
  CONSTRAINT pk_user_id PRIMARY KEY (user_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;




-- Table: books

-- DROP TABLE books;

CREATE TABLE books
(
  book_id integer NOT NULL,
  book_name character(100) NOT NULL,
  author character(50) NOT NULL,
  publish_date date,
  entry_date date NOT NULL,
  category_id integer NOT NULL,
  CONSTRAINT pk_book_id PRIMARY KEY (book_id),
  CONSTRAINT fk_category_id FOREIGN KEY (category_id)
      REFERENCES book_category (category_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE books
  OWNER TO postgres;




-- Table: book_category

-- DROP TABLE book_category;

CREATE TABLE book_category
(
  category_id integer NOT NULL,
  category_name character(30) NOT NULL,
  CONSTRAINT pk_book_category PRIMARY KEY (category_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE book_category
  OWNER TO postgres;





