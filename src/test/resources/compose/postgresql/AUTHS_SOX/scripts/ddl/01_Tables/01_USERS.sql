CREATE TABLE USERS (
    ID               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    USER_NAME        VARCHAR(255) NOT NULL,
    PASSWORD         VARCHAR(255) NOT NULL,
    CONSTRAINT PK_USERS PRIMARY KEY (ID)
);
