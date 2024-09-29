CREATE TABLE loan
(
    id          INT          NOT NULL PRIMARY KEY,
    user_id     INT          NOT NULL,
    book_id     INT          NOT NULL,
    loaned_at   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    returned_at TIMESTAMP    NOT NULL,
    status      VARCHAR(255) NOT NULL
);

ALTER TABLE loan
    ADD FOREIGN KEY (user_id) REFERENCES "user"(id);
ALTER TABLE loan
    ADD FOREIGN KEY (book_id) REFERENCES book(id);