DROP TABLE if EXISTS users;
DROP TABLE if EXISTS book;
DROP TABLE if EXISTS loan;

CREATE TABLE users
(
    id                      BIGINT NOT NULL      AUTO_INCREMENT,
    email                   VARCHAR(55)          NOT     NULL,
    nickname                VARCHAR(20)          NOT     NULL,
    password                VARCHAR(100)         NOT     NULL,
    deleted_at              TIMESTAMP                    NULL,
    created_date            TIMESTAMP            NOT     NULL,
    updated_date            TIMESTAMP            NOT     NULL,
    PRIMARY KEY (id)
);

CREATE TABLE book
(
    id                      BIGINT NOT NULL      AUTO_INCREMENT,
    title                   VARCHAR(100)         NOT    NULL,
    author                  VARCHAR(50)          NOT    NULL,
    publisher               VARCHAR(50)          NOT    NULL,
    loan_status             varchar(50)          NOT    NULL,
    deleted_at              TIMESTAMP                   NULL,
    published_at            TIMESTAMP            NOT    NULL,
    created_date            TIMESTAMP            NOT    NULL,
    updated_date            TIMESTAMP            NOT    NULL,
    PRIMARY KEY (id)
);

CREATE TABLE loan
(
    id                      BIGINT NOT NULL      AUTO_INCREMENT,
    user_id                 BIGINT               NOT    NULL,
    book_id                 BIGINT               NOT    NULL,
    penalty                 int                         NULL,
    due_date                TIMESTAMP            NOT    NULL,
    deleted_at              TIMESTAMP                   NULL,
    return_date             TIMESTAMP                   NULL,
    created_date            TIMESTAMP            NOT    NULL,
    updated_date            TIMESTAMP            NOT    NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tag
(
    id                      BIGINT NOT NULL      AUTO_INCREMENT,
    name                    varchar(50)          NOT NULL UNIQUE,
    deleted_at              TIMESTAMP                   NULL,
    created_date            TIMESTAMP            NOT    NULL,
    updated_date            TIMESTAMP            NOT    NULL,
    PRIMARY KEY (id)
);

CREATE TABLE book_tag
(
    id                      BIGINT NOT NULL      AUTO_INCREMENT,
    book_id                 BIGINT               NOT    NULL,
    tag_id                  BIGINT               NOT    NULL,

);