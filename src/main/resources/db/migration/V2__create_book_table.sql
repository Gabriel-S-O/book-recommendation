CREATE TABLE book
(
    id           INT          NOT NULL PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    author       VARCHAR(255) NOT NULL,
    isbn         VARCHAR(255) NOT NULL,
    category     VARCHAR(255) NOT NULL,
    published_at TIMESTAMP    NOT NULL
);
