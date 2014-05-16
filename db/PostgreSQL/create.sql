-- Table: users

-- DROP TABLE users;

CREATE TABLE users
(
  user_id integer NOT NULL,
  name character varying(50) NOT NULL,
  birthday date,
  password character varying(50) NOT NULL DEFAULT 123,
  sex smallint DEFAULT 1,
  email character varying,
  mobile character varying(25),
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
  book_name character varying(50) NOT NULL,
  author character varying(50) NOT NULL,
  publish_date date,
  entry_date date NOT NULL,
  category_id integer NOT NULL,
  price numeric,
  intro character varying, -- introduction to the book
  total_number smallint NOT NULL, -- the number of books that library can offer
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
  category_name character varying(30) NOT NULL,
  CONSTRAINT pk_book_category PRIMARY KEY (category_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE book_category
  OWNER TO postgres;





