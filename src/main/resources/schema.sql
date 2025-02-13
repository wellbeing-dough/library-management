DROP TABLE if EXISTS users;

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


