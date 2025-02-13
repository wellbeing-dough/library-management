DROP TABLE if EXISTS users;
DROP TABLE if EXISTS book;
DROP TABLE if EXISTS laon;

CREATE TABLE users
(
    id                      BIGINT NOT NULL      AUTO_INCREMENT,
    email                   VARCHAR(55)          NOT     NULL,
    nickname                VARCHAR(20)          NOT     NULL,
    password                VARCHAR(100)         NOT     NULL,
    deleted_at              TIMESTAMP(3)         DEFAULT NULL,
    created_date            TIMESTAMP(3)         DEFAULT NULL,
    updated_date            TIMESTAMP(3)         DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE book
(
    id                      BIGINT NOT NULL      AUTO_INCREMENT,
    title                   VARCHAR(100)         NOT    NULL,
    author                  VARCHAR(50)          NOT    NULL,
    publisher               VARCHAR(50)          NOT    NULL,
    deleted_at              TIMESTAMP(3)         DEFAULT NULL,
    created_date            TIMESTAMP(3)         DEFAULT NULL,
    updated_date            TIMESTAMP(3)         DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE loan
(
    id                      BIGINT NOT NULL      AUTO_INCREMENT,
    user_id                 BIGINT               NOT    NULL,
    book_id                 BIGINT               NOT    NULL,
    due_date                TIMESTAMP(3)         DEFAULT NULL,
    deleted_at              TIMESTAMP(3)         DEFAULT NULL,
    return_date             TIMESTAMP(3)         DEFAULT NULL,
    created_date            TIMESTAMP(3)         DEFAULT NULL,
    updated_date            TIMESTAMP(3)         DEFAULT NULL,
    PRIMARY KEY (id)
);
