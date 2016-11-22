USE bookstore;
CREATE TABLE category(
  id VARCHAR(100) PRIMARY KEY ,
  name VARCHAR(100) NOT NULL UNIQUE ,
  description VARCHAR(255)
) DEFAULT CHARACTER SET utf8;

CREATE TABLE book (
  id VARCHAR(100) PRIMARY KEY ,
  name VARCHAR(100) NOT NULL ,
  author VARCHAR(100) ,
  money FLOAT(8, 2) ,
  description VARCHAR(255) ,
  path VARCHAR(100) ,
  oldImage VARCHAR(100) ,
  newImage VARCHAR(100) ,
  categoryId VARCHAR(100),
  CONSTRAINT category_fk FOREIGN KEY (categoryId) REFERENCES category(id)
) DEFAULT CHARACTER SET utf8;
